
public class FQueue<T> {

    Node<T> head;
    Node<T> tail;

    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    FQueue() {

    }

    FQueue(T[] initial) {
        if (initial.length != 0) {
            this.head = new Node<T>(initial[0]);
            Node<T> c = head;
            for (int i = 1; i < initial.length; i++) {
                Node<T> t = new Node<T>(initial[i]);
                c.next = t;
                c = t;
            }
            this.tail = c;
        }
    }

    public void enqueue(T ne) {
        if (this.tail == null) {
            this.tail = this.head = new Node<T>(ne);
        } else {
            this.tail.next = new Node<T>(ne);
            this.tail = this.tail.next;
        }
    }

    public T dequeue() {
        if (this.head == null) {
            return null;
        }

        T result = this.head.value;
        System.out.println("Result: " + result);
        Node<T> t = this.head;
        this.head = this.head.next;
        t.next = null;

        if (this.head == null) {
            this.tail = null;
        }

        return result;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.value;
    }

    @Override
    public String toString() {
        String r = "[";
        Node<T> c = this.head;
        while (c != null) {
            r += c.value + ", ";
            c = c.next;
        }
        r += "]";
        return r;
    }

    
}
