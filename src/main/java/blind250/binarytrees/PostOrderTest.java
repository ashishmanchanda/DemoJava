package blind250.binarytrees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PostOrderTest {

    /**
     * Test post-order traversal with the example tree from the original code
     *       1
     *      / \
     *     2   3
     *    / \   \
     *   4   5   6
     * Expected: 4 5 2 6 3 1
     */
    @Test
    public void testPostOrderWithExampleTree() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.right = new PostOrderNode(3);
        root.left.left = new PostOrderNode(4);
        root.left.right = new PostOrderNode(5);
        root.right.right = new PostOrderNode(6);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(6);
        expected.add(3);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with a null tree
     * Expected: empty list
     */
    @Test
    public void testPostOrderWithNullTree() {
        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(null, result);

        assertTrue(result.isEmpty());
    }

    /**
     * Test post-order traversal with a single node tree
     * Expected: [1]
     */
    @Test
    public void testPostOrderWithSingleNode() {
        PostOrderNode root = new PostOrderNode(1);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with only left children (skewed left tree)
     *     1
     *    /
     *   2
     *  /
     * 3
     * Expected: 3 2 1
     */
    @Test
    public void testPostOrderWithLeftSkewedTree() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.left.left = new PostOrderNode(3);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with only right children (skewed right tree)
     * 1
     *  \
     *   2
     *    \
     *     3
     * Expected: 3 2 1
     */
    @Test
    public void testPostOrderWithRightSkewedTree() {
        PostOrderNode root = new PostOrderNode(1);
        root.right = new PostOrderNode(2);
        root.right.right = new PostOrderNode(3);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with a complete binary tree
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *   4  5 6  7
     * Expected: 4 5 2 6 7 3 1
     */
    @Test
    public void testPostOrderWithCompleteBinaryTree() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.right = new PostOrderNode(3);
        root.left.left = new PostOrderNode(4);
        root.left.right = new PostOrderNode(5);
        root.right.left = new PostOrderNode(6);
        root.right.right = new PostOrderNode(7);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(6);
        expected.add(7);
        expected.add(3);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with a tree with only left child at root
     *     1
     *    /
     *   2
     * Expected: 2 1
     */
    @Test
    public void testPostOrderWithOnlyLeftChild() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with a tree with only right child at root
     * 1
     *  \
     *   2
     * Expected: 2 1
     */
    @Test
    public void testPostOrderWithOnlyRightChild() {
        PostOrderNode root = new PostOrderNode(1);
        root.right = new PostOrderNode(2);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with a deep tree (height = 5)
     * Expected: 5 4 3 2 1
     */
    @Test
    public void testPostOrderWithDeepTree() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.left.left = new PostOrderNode(3);
        root.left.left.left = new PostOrderNode(4);
        root.left.left.left.left = new PostOrderNode(5);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);

        assertEquals(expected, result);
    }

    /**
     * Test post-order traversal with negative and large values
     *       10
     *      /  \
     *    -5    20
     *   / \     \
     * -20  0    100
     * Expected: -20 0 -5 100 20 10
     */
    @Test
    public void testPostOrderWithNegativeAndLargeValues() {
        PostOrderNode root = new PostOrderNode(10);
        root.left = new PostOrderNode(-5);
        root.right = new PostOrderNode(20);
        root.left.left = new PostOrderNode(-20);
        root.left.right = new PostOrderNode(0);
        root.right.right = new PostOrderNode(100);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(0);
        expected.add(-5);
        expected.add(100);
        expected.add(20);
        expected.add(10);

        assertEquals(expected, result);
    }

    /**
     * Test that the result list contains all nodes
     */
    @Test
    public void testPostOrderResultSize() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.right = new PostOrderNode(3);
        root.left.left = new PostOrderNode(4);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        assertEquals(4, result.size());
    }

    /**
     * Test post-order traversal maintains insertion order in result list
     */
    @Test
    public void testPostOrderTraversalOrder() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(2);
        root.right = new PostOrderNode(3);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        // In post-order: left subtree, right subtree, root
        assertEquals(2, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(1, result.get(2));
    }

    /**
     * Test post-order traversal with duplicate values in tree
     *     1
     *    / \
     *   1   1
     *  / \
     * 1   1
     * Expected: 1 1 1 1 1
     */
    @Test
    public void testPostOrderWithDuplicateValues() {
        PostOrderNode root = new PostOrderNode(1);
        root.left = new PostOrderNode(1);
        root.right = new PostOrderNode(1);
        root.left.left = new PostOrderNode(1);
        root.left.right = new PostOrderNode(1);

        ArrayList<Integer> result = new ArrayList<>();
        PostOrder.postOrder(root, result);

        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            expected.add(1);
        }

        assertEquals(expected, result);
        assertEquals(5, result.size());
    }
}

