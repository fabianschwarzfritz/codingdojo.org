import java.lang.reflect.Array;

public class BinaryTree<T> {

    public static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
    }

    Node<T> root;

    public boolean compareBinaryTree(BinaryTree<T> other) {
        return recurseCompare(this.root, other.root);
    }

    public boolean recurseCompare(Node<T> a, Node<T> b) {
        if (a == null  && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        boolean leftSame = recurseCompare(a.left, b.left);
        boolean rightSame = recurseCompare(a.right, b.right);

        boolean valueSame = a.value.equals(b.value);

        return leftSame == rightSame && valueSame;
    };

    public boolean searchDFS(T needle) {
        FStack<Node<T>> s = new FStack<>();

        s.push(root);

        while(s.peek() != null) {
            Node<T> curr = s.pop();
            if (curr.value.equals(needle)) {
                return true;
            }

            if (curr.left != null) {
                s.push(curr.left);
            }

            if (curr.right != null) {
                s.push(curr.right);
            }
        }

        return false;
    }

    public boolean searchBFS(T n) {
        FQueue<Node<T>> q = new FQueue<Node<T>>();

        q.enqueue(this.root);;

        while (q.peek() != null) {
            Node<T> next = q.dequeue();
            if (next.value.equals(n)) {
                return true;
            }
            if (next.left != null) {
                q.enqueue(next.left);
            }
            if (next.right != null) {
                q.enqueue(next.right);
            }
        }
        return false;
    }

    public T[] inOrderList() {
        FLinkedList<T> l = new FLinkedList<>();
        traversalInOrder(this.root, l);
        return toArray(l);
    }

    public void traversalInOrder(Node<T> n, FLinkedList<T> l) {
        if (n == null) {
            return;
        }

        this.traversalInOrder(n.left, l);
        l.append(n.value);
        this.traversalInOrder(n.right, l);
    }

    public T[] preOrderList() {
        FLinkedList<T> l = new FLinkedList<>();
        traveralPreOrder(this.root, l);
        return this.toArray(l);
    }

    public T[] postOrderList() {
        FLinkedList<T> l = new FLinkedList<>();
        traversalPostOrder(this.root, l);
        return this.toArray(l);
    }

    private void traversalPostOrder(Node<T> n, FLinkedList<T> l) {
        if (n == null) {
            return;
        }
        traversalPostOrder(n.left, l);
        traversalPostOrder(n.right, l);
        l.append(n.value);
    }

    private void traveralPreOrder(Node<T> n, FLinkedList<T> l) {
        if (n == null) {
            return;
        }
        l.append(n.value);
        this.traveralPreOrder(n.left, l);
        this.traveralPreOrder(n.right, l);
    }

    private T[] toArray(FLinkedList<T> l) {
        // Yes I know this can explode
        T f = l.get(0);
        T[] t = (T[]) Array.newInstance(f.getClass(), l.length);

        for (int i = 0; i < l.length; i++) {
            t[i] = l.get(i);
        }
        return t;
    }
    
}
