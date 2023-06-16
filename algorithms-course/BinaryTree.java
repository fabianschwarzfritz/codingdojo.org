import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;

public class BinaryTree<T extends Comparable<T>> {

    public static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left;
        Node<T> right;
    }

    // For the Binary Search tree we need it to be comparable
    Node<T> root;

    public void deleteBST(T n) {
        Exception e = new NoSuchAlgorithmException();
        throw new RuntimeException(e);
    }

    public void insertBST(T n) {
        recursiveInsertBST(n, null, root);
    }

    public void recursiveInsertBST(T n, Node<T> p, Node<T> c) {
        if (c == null) {
            if (p.left == null) {
                p.left = new Node<T>();
                p.left.value = n;
            } else if (p.right == null) {
                p.right = new Node<T>();
                p.right.value = n;
            }
            return;
        }

        if (c.value.compareTo(n) < 0) {
            recursiveInsertBST(n, c, c.left);
        } else {
            recursiveInsertBST(n, c, c.right);
        }
    }

    public boolean findInBinarySearchTree(T n) {
        if (n == null) {
            throw new RuntimeException("n cannot be null");
        }

        return this.recursiveFind(n, this.root);
    }

    public boolean recursiveFind(T n, Node<T> s) {
        if (s == null) {
            return false;
        }
        if (s.value.equals(n)) {
            return true;
        }

        if (s.value.compareTo(n) < 0) {
            return recursiveFind(n, s.right);
        } else {
            return recursiveFind(n, s.left);
        }

    }

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
