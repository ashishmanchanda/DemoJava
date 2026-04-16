package blind250.binarytrees;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class RightViewTest {

    @Test
    public void returnsEmptyListForNullTree() {
        assertEquals(Collections.emptyList(), RightView.rightView(null));
    }

    @Test
    public void returnsRootForSingleNodeTree() {
        RightViewNode root = new RightViewNode(10);

        assertEquals(Collections.singletonList(10), RightView.rightView(root));
    }

    @Test
    public void returnsVisibleNodesForBalancedTree() {
        RightViewNode root = new RightViewNode(1);
        root.left = new RightViewNode(2);
        root.right = new RightViewNode(3);
        root.left.left = new RightViewNode(4);
        root.left.right = new RightViewNode(5);
        root.right.right = new RightViewNode(6);

        assertEquals(Arrays.asList(1, 3, 6), RightView.rightView(root));
    }

    @Test
    public void includesLeftNodeWhenRightSideIsMissingAtALevel() {
        RightViewNode root = new RightViewNode(1);
        root.left = new RightViewNode(2);
        root.right = new RightViewNode(3);
        root.left.right = new RightViewNode(5);
        root.left.right.left = new RightViewNode(7);
        root.right.left = new RightViewNode(4);

        assertEquals(Arrays.asList(1, 3, 4, 7), RightView.rightView(root));
    }
}
