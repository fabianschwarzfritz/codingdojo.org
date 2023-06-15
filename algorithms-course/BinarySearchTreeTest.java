import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTreeTest {
    
    private BinaryTree<Integer> sampleBindarySearchTree() {

        BinaryTree<Integer> t = new BinaryTree<>();

        BinaryTree.Node<Integer> n = new BinaryTree.Node<>();
        n.value = 10;
        BinaryTree.Node<Integer> l1 = new BinaryTree.Node<Integer>();
        l1.value = 5;
        BinaryTree.Node<Integer> l2 = new BinaryTree.Node<Integer>();
        l2.value = 3;
        BinaryTree.Node<Integer> l3 = new BinaryTree.Node<Integer>();
        l3.value = 7;
        BinaryTree.Node<Integer> l4 = new BinaryTree.Node<Integer>();
        l4.value = 1;
        BinaryTree.Node<Integer> l5 = new BinaryTree.Node<Integer>();
        l5.value = 4;

        BinaryTree.Node<Integer> r1 = new BinaryTree.Node<Integer>();
        r1.value = 12;
        BinaryTree.Node<Integer> r2 = new BinaryTree.Node<Integer>();
        r2.value = 11;
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
    public void testBSTFindTrue() {
        BinaryTree<Integer> b = sampleBindarySearchTree();
        boolean result = b.findInBinarySearchTree(11);
        assertEquals(true, result);
    }

    @Test
    public void testBSTFindFalse() {
        BinaryTree<Integer> b = sampleBindarySearchTree();
        boolean result = b.findInBinarySearchTree(1123123);
        assertEquals(false, result);
    }

    @Test
    public void testBSTInsert() {
        BinaryTree<Integer> b = sampleBindarySearchTree();
        b.insertBST(9);

        BinaryTree<Integer> exp = sampleBindarySearchTree();
        BinaryTree.Node<Integer> a = new BinaryTree.Node<Integer>();
        a.value = 9;
        exp.root.left.right.right = a;

        boolean same = b.compareBinaryTree(exp);
        assertEquals(true, same);
    }


}
