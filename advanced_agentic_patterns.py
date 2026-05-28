"""
Advanced Agentic AI: Real-World Implementation Patterns
========================================================

This module provides production-ready patterns using:
- ReAct (Reasoning + Acting) loop
- Chain-of-Thought prompting
- Tool use with validation
- Memory persistence
- Error recovery strategies

To use with real LLMs:
pip install langchain openai python-dotenv
"""

from typing import List, Dict, Any, Optional, Tuple
from dataclasses import dataclass
from enum import Enum
import json
from abc import ABC, abstractmethod


# ============================================================================
# 1. ADVANCED PATTERNS
# ============================================================================

class PromptTemplate:
    """Template for LLM prompts"""

    REACT_PROMPT = """
    Answer the following question step by step.
    You can use the following tools: {tools}

    Thought: {thought}
    Action: {action}
    Action Input: {action_input}
    Observation: {observation}

    Repeat the above steps until you have the final answer.
    Final Answer: {final_answer}
    """

    CHAIN_OF_THOUGHT = """
    Let me break this down step by step:
    1. What is being asked?
    2. What information do I need?
    3. What tools can help?
    4. What is the solution?

    Reasoning: {reasoning}
    Conclusion: {conclusion}
    """

    TOOL_VALIDATION = """
    I need to use a tool. Let me validate:
    - Tool: {tool_name}
    - Purpose: {purpose}
    - Inputs: {inputs}
    - Expected Output: {expected_output}
    - Error Handling: {error_handling}
    """


class ReActLoop:
    """
    ReAct (Reasoning + Acting) Implementation
    Combines LLM reasoning with tool execution
    """

    def __init__(self, max_iterations: int = 5):
        self.max_iterations = max_iterations
        self.iteration_history: List[Dict] = []

    def run(self, question: str, available_tools: List[str]) -> str:
        """
        Execute ReAct loop:
        Thought → Action → Observation → Thought → ...
        """
        print(f"\n📊 ReAct Loop Starting")
        print(f"Question: {question}")
        print(f"Available Tools: {', '.join(available_tools)}\n")

        for i in range(self.max_iterations):
            step = {
                "iteration": i + 1,
                "thought": "",
                "action": "",
                "observation": ""
            }

            # Thought: LLM reasons about the problem
            step["thought"] = self._generate_thought(question, i)
            print(f"🤔 Thought {i+1}: {step['thought']}")

            # Action: Decide which tool to use
            action, action_input = self._select_action(step["thought"], available_tools)
            step["action"] = action
            print(f"🔧 Action {i+1}: {action}({action_input})")

            # Observation: Execute tool and get result
            observation = self._execute_action(action, action_input)
            step["observation"] = observation
            print(f"👁️  Observation {i+1}: {observation}\n")

            self.iteration_history.append(step)

            # Check if we have the answer
            if self._is_final_answer(observation):
                return observation

        return "Unable to find answer within max iterations"

    def _generate_thought(self, question: str, iteration: int) -> str:
        """Generate reasoning step"""
        thoughts = [
            f"I need to understand what's being asked: {question}",
            "Let me search for relevant information",
            "Now I need to analyze this information",
            "I should validate my findings",
            "Let me synthesize the final answer"
        ]
        return thoughts[min(iteration, len(thoughts) - 1)]

    def _select_action(self, thought: str, available_tools: List[str]) -> Tuple[str, str]:
        """Select which tool to use based on thought"""
        # Simplified tool selection
        if "search" in thought.lower() or "find" in thought.lower():
            return "search", "information about " + thought
        elif "analyze" in thought.lower() or "calculate" in thought.lower():
            return "analyze", "data"
        else:
            return "summarize", thought

    def _execute_action(self, action: str, action_input: str) -> str:
        """Execute the selected action (mock)"""
        results = {
            "search": f"Found information: {action_input[:50]}...",
            "analyze": f"Analysis complete: Pattern identified in {action_input}",
            "summarize": f"Summary: {action_input[:100]}..."
        }
        return results.get(action, "Action executed")

    def _is_final_answer(self, observation: str) -> bool:
        """Check if we have sufficient information for final answer"""
        return "Analysis complete" in observation or "information:" in observation


class ChainOfThought:
    """
    Chain-of-Thought Prompting Strategy
    Breaking complex problems into smaller steps
    """

    def __init__(self):
        self.steps: List[Dict] = []

    def decompose_problem(self, problem: str) -> List[str]:
        """Break problem into smaller steps"""
        steps = [
            f"Understanding: What is being asked in '{problem}'?",
            f"Information Gathering: What data is needed?",
            f"Analysis: How should we approach this?",
            f"Solution: What's the best solution?",
            f"Validation: Is our solution correct?"
        ]
        return steps

    def solve_step_by_step(self, problem: str) -> Dict[str, Any]:
        """Solve by going through each step"""
        print(f"\n🔗 Chain-of-Thought Reasoning")
        print(f"Problem: {problem}\n")

        steps = self.decompose_problem(problem)
        results = {
            "problem": problem,
            "steps": [],
            "final_answer": ""
        }

        for i, step in enumerate(steps, 1):
            print(f"Step {i}: {step}")
            answer = self._answer_step(step)
            print(f"  → {answer}\n")

            results["steps"].append({
                "number": i,
                "question": step,
                "answer": answer
            })

        results["final_answer"] = self._synthesize_answer(results["steps"])
        return results

    def _answer_step(self, step: str) -> str:
        """Generate answer for a step (mock)"""
        if "Understanding" in step:
            return "The problem requires analytical thinking"
        elif "Information" in step:
            return "We need relevant data and context"
        elif "Analysis" in step:
            return "Use systematic decomposition"
        elif "Solution" in step:
            return "Apply best practices and tools"
        else:
            return "Results are verified and correct"

    def _synthesize_answer(self, steps: List[Dict]) -> str:
        """Combine all steps into final answer"""
        return f"Based on {len(steps)} reasoning steps, the solution is complete and validated"


# ============================================================================
# 2. TOOL MANAGEMENT & VALIDATION
# ============================================================================

@dataclass
class ToolSpec:
    """Specification for a tool"""
    name: str
    description: str
    parameters: Dict[str, str]
    required_params: List[str]
    error_handling: str


class ToolValidator:
    """Validate tool usage before execution"""

    def __init__(self):
        self.tool_specs = self._load_tool_specs()
        self.execution_history: List[Dict] = []

    def _load_tool_specs(self) -> Dict[str, ToolSpec]:
        """Load available tool specifications"""
        return {
            "search": ToolSpec(
                name="search",
                description="Search for information",
                parameters={"query": "str", "limit": "int"},
                required_params=["query"],
                error_handling="Return empty results if not found"
            ),
            "calculate": ToolSpec(
                name="calculate",
                description="Perform calculations",
                parameters={"expression": "str"},
                required_params=["expression"],
                error_handling="Handle mathematical errors gracefully"
            ),
            "fetch": ToolSpec(
                name="fetch",
                description="Fetch data from API",
                parameters={"url": "str", "method": "str"},
                required_params=["url"],
                error_handling="Retry with exponential backoff"
            )
        }

    def validate_tool_usage(self, tool_name: str, params: Dict) -> Tuple[bool, str]:
        """Validate tool usage"""
        if tool_name not in self.tool_specs:
            return False, f"Tool '{tool_name}' not found"

        spec = self.tool_specs[tool_name]

        # Check required parameters
        for required in spec.required_params:
            if required not in params:
                return False, f"Missing required parameter: {required}"

        # Validate parameter types
        for param_name, param_type in spec.parameters.items():
            if param_name in params:
                # Type validation would go here
                pass

        return True, "Validation passed"

    def log_execution(self, tool_name: str, params: Dict, result: Any, error: Optional[str] = None):
        """Log tool execution for audit trail"""
        self.execution_history.append({
            "tool": tool_name,
            "parameters": params,
            "result": result,
            "error": error,
            "timestamp": "2024-01-01T12:00:00Z"  # Would use real timestamp
        })


# ============================================================================
# 3. MEMORY STRATEGIES
# ============================================================================

class MemoryStrategy(ABC):
    """Abstract base for memory strategies"""

    @abstractmethod
    def store(self, key: str, value: Any) -> None:
        pass

    @abstractmethod
    def retrieve(self, key: str) -> Optional[Any]:
        pass


class ShortTermMemory(MemoryStrategy):
    """Short-term memory: Current context"""

    def __init__(self, max_items: int = 10):
        self.data: Dict = {}
        self.max_items = max_items
        self.access_count: Dict = {}

    def store(self, key: str, value: Any) -> None:
        self.data[key] = value
        self.access_count[key] = 0

        if len(self.data) > self.max_items:
            # Remove least accessed item
            lru_key = min(self.access_count, key=self.access_count.get)
            del self.data[lru_key]
            del self.access_count[lru_key]

    def retrieve(self, key: str) -> Optional[Any]:
        if key in self.data:
            self.access_count[key] += 1
            return self.data[key]
        return None


class LongTermMemory(MemoryStrategy):
    """Long-term memory: Persistent knowledge"""

    def __init__(self):
        self.knowledge_base: Dict = {}
        self.relationships: List[Tuple] = []

    def store(self, key: str, value: Any) -> None:
        self.knowledge_base[key] = value

    def retrieve(self, key: str) -> Optional[Any]:
        return self.knowledge_base.get(key)

    def add_relationship(self, entity1: str, relation: str, entity2: str):
        """Store relationships between entities"""
        self.relationships.append((entity1, relation, entity2))

    def query_relationships(self, entity: str) -> List[Tuple]:
        """Query relationships for an entity"""
        return [r for r in self.relationships if r[0] == entity or r[2] == entity]


# ============================================================================
# 4. ERROR RECOVERY STRATEGIES
# ============================================================================

class ErrorRecoveryStrategy:
    """Strategies for error handling and recovery"""

    def __init__(self):
        self.retry_count = 3
        self.backoff_strategy = "exponential"  # or "linear"

    def handle_tool_error(self, error: Exception, tool_name: str, attempt: int) -> str:
        """Handle tool execution errors"""
        print(f"\n⚠️  Error in tool '{tool_name}' (Attempt {attempt}/{self.retry_count})")
        print(f"   Error: {str(error)}")

        if attempt < self.retry_count:
            wait_time = self._calculate_backoff(attempt)
            print(f"   Retrying in {wait_time}s...")
            return "RETRY"
        else:
            recovery = self._fallback_strategy(tool_name)
            print(f"   Fallback: {recovery}")
            return "FALLBACK"

    def _calculate_backoff(self, attempt: int) -> int:
        """Calculate wait time before retry"""
        if self.backoff_strategy == "exponential":
            return 2 ** attempt
        else:
            return attempt

    def _fallback_strategy(self, tool_name: str) -> str:
        """Provide fallback when tool fails"""
        fallbacks = {
            "search": "Use cached results",
            "calculate": "Approximate the answer",
            "fetch": "Use offline data"
        }
        return fallbacks.get(tool_name, "Skip this step")


# ============================================================================
# 5. DEMONSTRATION & USAGE EXAMPLES
# ============================================================================

def demo_react_pattern():
    """Demonstrate ReAct pattern"""
    print("\n" + "="*70)
    print("📊 PATTERN 1: ReAct (Reasoning + Acting)")
    print("="*70)

    react = ReActLoop(max_iterations=3)
    tools = ["search", "analyze", "summarize"]

    answer = react.run(
        "What are the key benefits of machine learning?",
        tools
    )

    print(f"\n✅ Final Answer: {answer}")
    print(f"📋 Iterations: {len(react.iteration_history)}")


def demo_chain_of_thought():
    """Demonstrate Chain-of-Thought reasoning"""
    print("\n" + "="*70)
    print("🔗 PATTERN 2: Chain-of-Thought")
    print("="*70)

    cot = ChainOfThought()
    result = cot.solve_step_by_step("How to build a recommendation system?")

    print(f"✅ Solution: {result['final_answer']}")


def demo_tool_validation():
    """Demonstrate tool validation"""
    print("\n" + "="*70)
    print("🔧 PATTERN 3: Tool Validation")
    print("="*70)

    validator = ToolValidator()

    # Valid tool usage
    print("\n1. Valid Tool Usage:")
    is_valid, message = validator.validate_tool_usage("search", {"query": "AI agents"})
    print(f"   Result: {is_valid} - {message}")

    # Invalid tool
    print("\n2. Invalid Tool:")
    is_valid, message = validator.validate_tool_usage("invalid_tool", {})
    print(f"   Result: {is_valid} - {message}")

    # Missing parameters
    print("\n3. Missing Parameters:")
    is_valid, message = validator.validate_tool_usage("fetch", {})
    print(f"   Result: {is_valid} - {message}")


def demo_memory_strategies():
    """Demonstrate memory strategies"""
    print("\n" + "="*70)
    print("💾 PATTERN 4: Memory Strategies")
    print("="*70)

    # Short-term memory
    print("\n📝 Short-Term Memory (LRU Cache):")
    stm = ShortTermMemory(max_items=3)
    stm.store("current_task", "Processing request")
    stm.store("user_input", "What is AI?")
    print(f"   Stored: 'current_task' and 'user_input'")
    print(f"   Retrieved: {stm.retrieve('current_task')}")

    # Long-term memory
    print("\n📚 Long-Term Memory (Knowledge Base):")
    ltm = LongTermMemory()
    ltm.store("AI_definition", "Artificial Intelligence is...")
    ltm.add_relationship("AI", "is_a", "Technology")
    ltm.add_relationship("Agent", "uses", "AI")
    print(f"   Stored knowledge: 'AI_definition'")
    print(f"   Relationships: {ltm.query_relationships('AI')}")


def demo_error_recovery():
    """Demonstrate error recovery"""
    print("\n" + "="*70)
    print("🔄 PATTERN 5: Error Recovery")
    print("="*70)

    recovery = ErrorRecoveryStrategy()

    print("\nScenario: Tool fails")
    error = Exception("Connection timeout")
    recovery.handle_tool_error(error, "fetch", attempt=1)
    recovery.handle_tool_error(error, "fetch", attempt=2)
    recovery.handle_tool_error(error, "fetch", attempt=3)


# ============================================================================
# 6. MAIN EXECUTION
# ============================================================================

if __name__ == "__main__":
    print("\n" + "="*70)
    print("🚀 ADVANCED AGENTIC AI PATTERNS")
    print("   Production-Ready Implementation Strategies")
    print("="*70)

    # Run all demonstrations
    demo_react_pattern()
    demo_chain_of_thought()
    demo_tool_validation()
    demo_memory_strategies()
    demo_error_recovery()

    print("\n" + "="*70)
    print("✅ ALL PATTERNS DEMONSTRATED")
    print("="*70)
    print("""
    🎓 KEY TAKEAWAYS:

    1. ReAct Pattern:
       ✓ Combines reasoning with action
       ✓ Iterative problem-solving
       ✓ Tool-augmented intelligence

    2. Chain-of-Thought:
       ✓ Problem decomposition
       ✓ Step-by-step reasoning
       ✓ Verifiable logic

    3. Tool Validation:
       ✓ Pre-execution validation
       ✓ Parameter checking
       ✓ Audit trails

    4. Memory Management:
       ✓ Short-term: Fast access
       ✓ Long-term: Persistent knowledge
       ✓ Relationships: Context understanding

    5. Error Recovery:
       ✓ Exponential backoff
       ✓ Fallback strategies
       ✓ Graceful degradation

    🔗 REAL-WORLD INTEGRATION:

    To use with actual LLMs:

    1. Replace mock functions with real LLM calls
    2. Integrate with APIs (OpenAI, Anthropic, Hugging Face)
    3. Add persistent storage (Redis, PostgreSQL)
    4. Implement monitoring and logging
    5. Deploy with Docker/Kubernetes
    6. Add web UI for monitoring
    """)

