import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PreOrderBTTest {
    
    private BinaryTree<Integer> sampleTree() {

        BinaryTree<Integer> t = new BinaryTree<>();

        BinaryTree.Node<Integer> n = new BinaryTree.Node<>();
        n.value = 0;
        BinaryTree.Node<Integer> l1 = new BinaryTree.Node<Integer>();
        l1.value = 1;
        BinaryTree.Node<Integer> l2 = new BinaryTree.Node<Integer>();
        l2.value = 2;
        BinaryTree.Node<Integer> l3 = new BinaryTree.Node<Integer>();
        l3.value = 3;
        BinaryTree.Node<Integer> l4 = new BinaryTree.Node<Integer>();
        l4.value = 4;
        BinaryTree.Node<Integer> l5 = new BinaryTree.Node<Integer>();
        l5.value = 5;

        BinaryTree.Node<Integer> r1 = new BinaryTree.Node<Integer>();
        r1.value = 11;
        BinaryTree.Node<Integer> r2 = new BinaryTree.Node<Integer>();
        r2.value = 12;
        BinaryTree.Node<Integer> r3 = new BinaryTree.Node<Integer>();
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
        BinaryTree<Integer> t = sampleTree();
        Integer[] r =  t.preOrderList();
        assertArrayEquals(new Integer[]{
            0, 1, 2, 4, 5, 3, 11, 12, 13
        }, r);
    }

    @Test
    public void testInOrder() {
        BinaryTree<Integer> t = sampleTree();
        Integer[] r = t.inOrderList();
        assertArrayEquals(new Integer[]{
            4, 2, 5, 1, 3, 0, 12, 11, 13
        }, r);
    }

    @Test
    public void testPostOrder() {
        BinaryTree<Integer> t = sampleTree();
        Integer[] r = t.postOrderList();
        assertArrayEquals(new Integer[] {
            4, 5, 2, 3, 1, 12, 13, 11, 0
        }, r);
    }

    @Test
    public void testSearchBFS1() {
        BinaryTree<Integer> t = sampleTree();
        boolean contained = t.searchBFS(12);
        assertEquals(true, contained);
    }

    @Test
    public void testSearchBFS2() {
        BinaryTree<Integer> t = sampleTree();
        boolean contained = t.searchBFS(100);
        assertEquals(false, contained);
    }
    
}
