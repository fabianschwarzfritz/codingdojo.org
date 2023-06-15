
public class BinaryTree {

    public static class Node {
        int value;
        Node left;
        Node right;
    }

    Node root;

    public int[] inOrderList() {
        FLinkedList l = new FLinkedList();
        traversalInOrder(this.root, l);
        return toArray(l);
    }

    public void traversalInOrder(Node n, FLinkedList l) {
        if (n == null) {
            return;
        }

        this.traversalInOrder(n.left, l);
        l.append(n.value);
        this.traversalInOrder(n.right, l);
    }

    public int[] preOrderList() {
        FLinkedList l = new FLinkedList();
        traveralPreOrder(this.root, l);
        return this.toArray(l);
    }

    public int[] postOrderList() {
        FLinkedList l = new FLinkedList();
        traversalPostOrder(this.root, l);
        return this.toArray(l);
    }

    private void traversalPostOrder(Node n, FLinkedList l) {
        if (n == null) {
            return;
        }
        traversalPostOrder(n.left, l);
        traversalPostOrder(n.right, l);
        l.append(n.value);
    }

    private void traveralPreOrder(Node n, FLinkedList l) {
        if (n == null) {
            return;
        }
        l.append(n.value);
        this.traveralPreOrder(n.left, l);
        this.traveralPreOrder(n.right, l);
    }

    private int[] toArray(FLinkedList l) {
        int[] r = new int[l.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = l.get(i);
        }
        return r;
    }
    
}
