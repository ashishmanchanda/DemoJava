"""
Agentic AI Hands-On Project: Research Assistant Multi-Agent System
====================================================================

This project demonstrates:
1. Single Agent with Tool Usage
2. Multi-Agent Collaboration
3. Memory Management
4. Error Handling & Recovery
5. Human-in-the-Loop Decision Making

Requirements:
pip install requests python-dotenv

Note: For LLM, we use mock responses (no API keys needed for learning)
"""

from abc import ABC, abstractmethod
from dataclasses import dataclass
from enum import Enum
from typing import List, Dict, Any, Optional
import json
from datetime import datetime


# ============================================================================
# 1. CORE DATA STRUCTURES
# ============================================================================

class AgentRole(Enum):
    """Define different agent roles"""
    RESEARCHER = "researcher"
    ANALYZER = "analyzer"
    WRITER = "writer"
    VALIDATOR = "validator"


class TaskStatus(Enum):
    """Task execution status"""
    PENDING = "pending"
    IN_PROGRESS = "in_progress"
    COMPLETED = "completed"
    FAILED = "failed"
    BLOCKED = "blocked"


@dataclass
class Task:
    """Represents a task that an agent can execute"""
    id: str
    description: str
    required_role: AgentRole
    status: TaskStatus = TaskStatus.PENDING
    result: Optional[str] = None
    error: Optional[str] = None
    assigned_to: Optional[str] = None

    def __str__(self):
        return f"Task({self.id}, {self.required_role.value}, {self.status.value})"


@dataclass
class Memory:
    """Agent memory management"""
    short_term: Dict[str, Any]  # Current context
    long_term: Dict[str, Any]   # Persistent knowledge

    def remember_short(self, key: str, value: Any):
        self.short_term[key] = value

    def recall_short(self, key: str) -> Optional[Any]:
        return self.short_term.get(key)

    def remember_long(self, key: str, value: Any):
        self.long_term[key] = value

    def recall_long(self, key: str) -> Optional[Any]:
        return self.long_term.get(key)


# ============================================================================
# 2. TOOLS & CAPABILITIES
# ============================================================================

class Tool(ABC):
    """Abstract base class for agent tools"""

    def __init__(self, name: str, description: str):
        self.name = name
        self.description = description

    @abstractmethod
    def execute(self, *args, **kwargs) -> str:
        """Execute the tool and return result"""
        pass

    def __repr__(self):
        return f"Tool({self.name})"


class WebSearchTool(Tool):
    """Mock web search tool"""

    def __init__(self):
        super().__init__(
            "web_search",
            "Search the web for information about a topic"
        )

    def execute(self, query: str, num_results: int = 3) -> str:
        """Mock web search"""
        print(f"  🔍 Searching web for: '{query}'")
        # Mock search results
        results = [
            f"- Result 1: {query} explained - Comprehensive overview of {query}",
            f"- Result 2: {query} tutorial - Step-by-step guide to understanding {query}",
            f"- Result 3: {query} research - Latest developments in {query}"
        ]
        return "\n".join(results[:num_results])


class AnalysisTool(Tool):
    """Mock analysis tool"""

    def __init__(self):
        super().__init__(
            "analyze_data",
            "Analyze information and extract key insights"
        )

    def execute(self, data: str) -> str:
        """Mock data analysis"""
        print(f"  📊 Analyzing data...")
        analysis = f"""
        Analysis Results:
        - Key Points Identified: 3-5 main concepts
        - Relevance Score: 8.5/10
        - Credibility: High (based on source quality)
        - Summary: {data[:100]}...
        """
        return analysis.strip()


class ContentGenerationTool(Tool):
    """Mock content generation tool"""

    def __init__(self):
        super().__init__(
            "generate_content",
            "Generate well-structured written content"
        )

    def execute(self, topic: str, style: str = "professional") -> str:
        """Mock content generation"""
        print(f"  ✍️  Generating content about '{topic}'...")
        content = f"""
        # {topic}

        ## Introduction
        {topic} is an important subject in modern technology and business.

        ## Key Points
        1. First important aspect of {topic}
        2. Second important aspect of {topic}
        3. Third important aspect of {topic}

        ## Conclusion
        Understanding {topic} is crucial for success in the field.
        """
        return content.strip()


class ValidationTool(Tool):
    """Mock validation tool"""

    def __init__(self):
        super().__init__(
            "validate",
            "Validate content for accuracy and completeness"
        )

    def execute(self, content: str) -> str:
        """Mock validation"""
        print(f"  ✓ Validating content...")
        validation_result = f"""
        Validation Report:
        ✓ Grammar: Passed
        ✓ Structure: Passed
        ✓ Completeness: 95%
        ✓ Accuracy: High
        Recommendation: APPROVED for publication
        """
        return validation_result.strip()


# ============================================================================
# 3. AGENT IMPLEMENTATION
# ============================================================================

class Agent:
    """
    Base Agent class with autonomous decision-making capabilities
    """

    def __init__(self, name: str, role: AgentRole, tools: List[Tool]):
        self.name = name
        self.role = role
        self.tools = {tool.name: tool for tool in tools}
        self.memory = Memory(short_term={}, long_term={})
        self.max_iterations = 5
        self.current_iteration = 0

    def plan(self, task: Task) -> List[str]:
        """
        Autonomous planning: Agent decides which tools to use
        """
        print(f"\n🤖 {self.name} ({self.role.value}) - PLANNING")
        plan = self._generate_plan(task)
        print(f"  📋 Plan: {' → '.join(plan)}")
        return plan

    def _generate_plan(self, task: Task) -> List[str]:
        """Generate execution plan based on task"""
        if self.role == AgentRole.RESEARCHER:
            return ["web_search", "analyze_data"]
        elif self.role == AgentRole.WRITER:
            return ["generate_content"]
        elif self.role == AgentRole.VALIDATOR:
            return ["validate"]
        return []

    def execute_plan(self, task: Task, plan: List[str]) -> str:
        """
        Execute the plan with tool usage and error handling
        """
        print(f"\n🤖 {self.name} - EXECUTING")
        result = None

        for step in plan:
            if step in self.tools:
                tool = self.tools[step]
                try:
                    if step == "web_search":
                        result = tool.execute(task.description)
                    elif step == "analyze_data":
                        result = tool.execute(result or task.description)
                    elif step == "generate_content":
                        result = tool.execute(task.description)
                    elif step == "validate":
                        result = tool.execute(result or task.description)

                    self.memory.remember_short(f"step_{step}", result)
                    print(f"  ✅ Tool '{step}' executed successfully")

                except Exception as e:
                    print(f"  ❌ Error in tool '{step}': {str(e)}")
                    return f"Error: {str(e)}"

        return result

    def think(self, task: Task, feedback: Optional[str] = None) -> Optional[Task]:
        """
        Reflection: Agent thinks about the result and decides next steps
        """
        print(f"\n🤖 {self.name} - THINKING")

        if feedback:
            print(f"  💭 Analyzing feedback: {feedback}")
            self.memory.remember_long(f"feedback_{task.id}", feedback)

        # Decide if task is complete
        print(f"  💭 Task status: Complete")
        return None  # No further action needed

    def execute(self, task: Task) -> Task:
        """
        Main execution loop: Plan → Act → Think → Reflect
        """
        task.assigned_to = self.name
        task.status = TaskStatus.IN_PROGRESS

        self.current_iteration = 0
        while self.current_iteration < self.max_iterations:
            self.current_iteration += 1

            # Plan
            plan = self.plan(task)

            # Execute
            result = self.execute_plan(task, plan)

            if result:
                task.result = result
                task.status = TaskStatus.COMPLETED

                # Think
                next_task = self.think(task)
                if not next_task:
                    break
            else:
                task.status = TaskStatus.FAILED
                break

        return task


# ============================================================================
# 4. MULTI-AGENT COORDINATOR
# ============================================================================

class MultiAgentCoordinator:
    """
    Coordinates multiple agents working on related tasks
    Implements task delegation and result aggregation
    """

    def __init__(self, agents: List[Agent]):
        self.agents = {agent.name: agent for agent in agents}
        self.task_queue: List[Task] = []
        self.completed_tasks: List[Task] = []
        self.human_in_loop_enabled = False

    def register_agent(self, agent: Agent):
        """Register a new agent in the system"""
        self.agents[agent.name] = agent
        print(f"✓ Agent registered: {agent.name} ({agent.role.value})")

    def create_task_pipeline(self, description: str, required_roles: List[AgentRole]) -> List[Task]:
        """
        Create a pipeline of tasks based on required roles
        """
        tasks = []
        for i, role in enumerate(required_roles):
            task = Task(
                id=f"task_{i}_{datetime.now().timestamp()}",
                description=description,
                required_role=role
            )
            tasks.append(task)
        return tasks

    def assign_task_to_agent(self, task: Task) -> Optional[Agent]:
        """
        Intelligently assign task to appropriate agent
        """
        for agent_name, agent in self.agents.items():
            if agent.role == task.required_role:
                print(f"\n📋 Assigning task to: {agent_name}")
                return agent
        return None

    def execute_task_pipeline(self, tasks: List[Task]):
        """
        Execute tasks in sequence with coordination
        """
        print("\n" + "="*70)
        print(f"🚀 MULTI-AGENT EXECUTION - {len(tasks)} tasks")
        print("="*70)

        for i, task in enumerate(tasks, 1):
            print(f"\n📌 Task {i}/{len(tasks)}: {task.required_role.value}")

            # Assign to appropriate agent
            agent = self.assign_task_to_agent(task)
            if not agent:
                task.status = TaskStatus.FAILED
                task.error = f"No agent found for role: {task.required_role}"
                print(f"  ❌ {task.error}")
                continue

            # Execute task
            task = agent.execute(task)

            # Human-in-the-loop review for critical tasks
            if self.human_in_loop_enabled and i == len(tasks):
                if not self._human_approval(task):
                    task.status = TaskStatus.BLOCKED
                    print(f"  🛑 Task blocked for revision")
                    continue

            self.completed_tasks.append(task)

        return self.completed_tasks

    def _human_approval(self, task: Task) -> bool:
        """
        Simulate human review for critical decisions
        In production, this would be an actual user interface
        """
        print(f"\n👤 HUMAN-IN-THE-LOOP REVIEW")
        print(f"   Task: {task.id}")
        print(f"   Status: {task.status.value}")
        print(f"   Result Preview: {task.result[:100] if task.result else 'N/A'}...")
        print(f"   ✓ Approved by human (auto-approved for demo)")
        return True

    def generate_report(self) -> str:
        """
        Generate execution report
        """
        report = "\n" + "="*70
        report += "\n📊 MULTI-AGENT EXECUTION REPORT\n"
        report += "="*70 + "\n"

        report += f"Total Tasks: {len(self.completed_tasks)}\n"
        completed = sum(1 for t in self.completed_tasks if t.status == TaskStatus.COMPLETED)
        report += f"Completed: {completed}/{len(self.completed_tasks)}\n"

        for task in self.completed_tasks:
            status_emoji = "✅" if task.status == TaskStatus.COMPLETED else "❌"
            report += f"\n{status_emoji} {task.id}\n"
            report += f"   Role: {task.required_role.value}\n"
            report += f"   Assigned to: {task.assigned_to}\n"
            report += f"   Status: {task.status.value}\n"
            if task.result:
                report += f"   Result: {task.result[:150]}...\n"

        return report


# ============================================================================
# 5. DEMONSTRATION
# ============================================================================

def demo_single_agent():
    """Demo: Single Agent with Tool Usage"""
    print("\n" + "🔷"*35)
    print("🔷 PROJECT 1: SINGLE AGENT - RESEARCH ASSISTANT")
    print("🔷"*35)

    # Create agent with tools
    tools = [
        WebSearchTool(),
        AnalysisTool(),
    ]
    researcher = Agent("Alice", AgentRole.RESEARCHER, tools)

    # Create and execute task
    task = Task(
        id="task_1",
        description="Research about Machine Learning",
        required_role=AgentRole.RESEARCHER
    )

    completed_task = researcher.execute(task)
    print(f"\n📋 Task Result:\n{completed_task.result}")


def demo_multi_agent_system():
    """Demo: Multi-Agent Collaboration"""
    print("\n" + "🔷"*35)
    print("🔷 PROJECT 2: MULTI-AGENT - CONTENT CREATION TEAM")
    print("🔷"*35)

    # Create specialized agents
    researcher = Agent(
        "Alice_Researcher",
        AgentRole.RESEARCHER,
        [WebSearchTool(), AnalysisTool()]
    )

    writer = Agent(
        "Bob_Writer",
        AgentRole.WRITER,
        [ContentGenerationTool()]
    )

    validator = Agent(
        "Carol_Validator",
        AgentRole.VALIDATOR,
        [ValidationTool()]
    )

    # Create coordinator
    coordinator = MultiAgentCoordinator([researcher, writer, validator])

    # Create task pipeline
    task_description = "Write a comprehensive guide about AI Agents"
    required_roles = [AgentRole.RESEARCHER, AgentRole.WRITER, AgentRole.VALIDATOR]
    tasks = coordinator.create_task_pipeline(task_description, required_roles)

    # Execute pipeline
    completed_tasks = coordinator.execute_task_pipeline(tasks)

    # Generate report
    report = coordinator.generate_report()
    print(report)


def demo_error_handling():
    """Demo: Error Handling and Recovery"""
    print("\n" + "🔷"*35)
    print("🔷 PROJECT 3: ERROR HANDLING & RECOVERY")
    print("🔷"*35)

    # Agent with error scenarios
    agent = Agent(
        "Error_Test_Agent",
        AgentRole.ANALYZER,
        [AnalysisTool()]
    )

    task = Task(
        id="error_task",
        description="Handle complex analysis with potential errors",
        required_role=AgentRole.ANALYZER
    )

    print(f"🤖 Agent '{agent.name}' starting task execution...")
    try:
        result = agent.execute(task)
        print(f"✅ Task completed with status: {result.status.value}")
    except Exception as e:
        print(f"❌ Error occurred: {str(e)}")
        print("🔄 Recovery mechanism activated...")


def demo_human_in_loop():
    """Demo: Human-in-the-Loop Decision Making"""
    print("\n" + "🔷"*35)
    print("🔷 PROJECT 4: HUMAN-IN-THE-LOOP SYSTEM")
    print("🔷"*35)

    # Create coordinator with HITL enabled
    researcher = Agent("Agent_1", AgentRole.RESEARCHER, [WebSearchTool()])
    writer = Agent("Agent_2", AgentRole.WRITER, [ContentGenerationTool()])
    validator = Agent("Agent_3", AgentRole.VALIDATOR, [ValidationTool()])

    coordinator = MultiAgentCoordinator([researcher, writer, validator])
    coordinator.human_in_loop_enabled = True

    tasks = coordinator.create_task_pipeline(
        "Create high-stakes content",
        [AgentRole.RESEARCHER, AgentRole.WRITER, AgentRole.VALIDATOR]
    )

    print("🔐 HUMAN-IN-THE-LOOP ENABLED")
    print("   Critical decisions require human approval\n")

    completed = coordinator.execute_task_pipeline(tasks)
    print(f"\n✅ Pipeline completed with {len(completed)} tasks")


# ============================================================================
# 6. MAIN EXECUTION
# ============================================================================

if __name__ == "__main__":
    print("\n" + "="*70)
    print("🚀 AGENTIC AI HANDS-ON PROJECT")
    print("   Demonstrating Multi-Agent Systems")
    print("="*70)

    # Run demonstrations
    demo_single_agent()
    demo_multi_agent_system()
    demo_error_handling()
    demo_human_in_loop()

    print("\n" + "="*70)
    print("✅ ALL DEMONSTRATIONS COMPLETED")
    print("="*70)
    print("""
    🎓 LEARNING OUTCOMES:
    ✓ Single agent architecture with tool usage
    ✓ Multi-agent coordination and task delegation
    ✓ Autonomous planning and decision-making
    ✓ Error handling and recovery mechanisms
    ✓ Human-in-the-loop workflows
    ✓ Memory management (short and long term)
    ✓ Agent specialization and role-based design

    🔗 NEXT STEPS:
    1. Modify tools to connect to real APIs
    2. Implement persistence with databases
    3. Add advanced planning algorithms (ReAct, Chain-of-Thought)
    4. Integrate with real LLMs (OpenAI, Hugging Face)
    5. Build web interface for monitoring
    6. Deploy as microservices
    """)

