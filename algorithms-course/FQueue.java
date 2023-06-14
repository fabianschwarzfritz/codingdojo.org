
public class FQueue {

    Node head;
    Node tail;

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    FQueue(int[] initial) {
        if (initial.length != 0) {
            this.head = new Node(initial[0]);
            Node c = head;
            for (int i = 1; i < initial.length; i++) {
                Node t = new Node(initial[i]);
                c.next = t;
                c = t;
            }
            this.tail = c;
        }
    }

    public void enqueue(int ne) {
        if (this.tail == null) {
            this.tail = this.head = new Node(ne);
        } else {
            this.tail.next = new Node(ne);
            this.tail = this.tail.next;
        }
    }

    public Integer dequeue() {
        if (this.head == null) {
            return null;
        }

        int result = this.head.value;
        Node t = this.head;
        this.head = this.head.next;
        t.next = null;
        return result;
    }

    public Integer peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.value;
    }

    @Override
    public String toString() {
        String r = "[";
        Node c = this.head;
        while (c != null) {
            r += c.value + ", ";
            c = c.next;
        }
        r += "]";
        return r;
    }

    
}
