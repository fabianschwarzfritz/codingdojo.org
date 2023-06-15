import java.util.ArrayList;

public class FStack<T> {
    
    public static class Node<T> {
        public T value;
        public Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;

    FStack() {

    }

    FStack(T[] initial) {
        if (initial.length != 0) {
            Node<T> t = new Node<T>(initial[0]);
            for (int i = 1; i < initial.length; i++) {
                Node<T> n = new Node<>(initial[i]);
                n.next = t;
                t = n;
            }
            this.head = t;
        }
    }

    public void push(T i) {
        Node<T> n = new Node<>(i);
        if (this.head != null) {
            n.next = this.head;
        }
        this.head = n;
    }

    public T pop() {
        if (this.head == null) {
            return null;
        }

        Node<T> n = this.head;
        T r = this.head.value;
        this.head = this.head.next;
        n.next = null;
        return r;
    }
    
    public T peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.value;
    }

    @Override
    public String toString() {
        // I know, I'm using array list here....
        ArrayList<Node<T>> result = new ArrayList<>();
        Node<T> t = this.head;
        while (t != null) {
            result.add(t);
            t = t.next;
        }

        String r = "[";
        for (int i = result.size() - 1; i >= 0; i--) {
            r += result.get(i).value + ", ";
        }
        r += "]";

        return r;
    }
    
}
