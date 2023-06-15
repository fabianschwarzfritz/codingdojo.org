import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PreOrderBTTest {
    
    private BinaryTree sampleTree() {

        BinaryTree t = new BinaryTree();

        BinaryTree.Node n = new BinaryTree.Node();
        n.value = 0;
        BinaryTree.Node l1 = new BinaryTree.Node();
        l1.value = 1;
        BinaryTree.Node l2 = new BinaryTree.Node();
        l2.value = 2;
        BinaryTree.Node l3 = new BinaryTree.Node();
        l3.value = 3;
        BinaryTree.Node l4 = new BinaryTree.Node();
        l4.value = 4;
        BinaryTree.Node l5 = new BinaryTree.Node();
        l5.value = 5;

        BinaryTree.Node r1 = new BinaryTree.Node();
        r1.value = 11;
        BinaryTree.Node r2 = new BinaryTree.Node();
        r2.value = 12;
        BinaryTree.Node r3 = new BinaryTree.Node();
        r3.value = 13;

        n.left = l1;
        l1.left = l2;
        l2.left = l4;
        l2.right = l5;
        l1.right = l3;
        n.right = r1;
        r1.left = r2;
        r1.right = r3;
        t.root = n;

        return t;
    }

    @Test
    public void testPreOrder() {
        BinaryTree t = sampleTree();
        int[] r =  t.preOrderList();
        assertArrayEquals(new int[]{
            0, 1, 2, 4, 5, 3, 11, 12, 13
        }, r);
    }

    @Test
    public void testInOrder() {
        BinaryTree t = sampleTree();
        int[] r = t.inOrderList();
        assertArrayEquals(new int[]{
            4, 2, 5, 1, 3, 0, 12, 11, 13
        }, r);
    }

    @Test
    public void testPostOrder() {
        BinaryTree t = sampleTree();
        int[] r = t.postOrderList();
        assertArrayEquals(new int[] {
            4, 5, 2, 3, 1, 12, 13, 11, 0
        }, r);
    }
    
}
