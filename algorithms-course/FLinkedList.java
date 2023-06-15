
public class FLinkedList {

    static class Node {
        int value;
        Node next;
    }

    private Node head;
    private int length;

    public int length() {
        return this.length;
    }

    public void append(int item) {
        ++length;
        if (this.head == null) {
            this.head = new Node();
            this.head.value = item;
        } else {
            Node c = this.head;
            while (c.next != null) {
                c = c.next;
            };
            c.next = new Node();
            c.next.value = item;
        }
    }
    
    public void removeAt(int pos) {
        if(pos < 0) {
            return;
        } else if (pos == 0) {
            Node c = this.head;
            this.head = this.head.next;
            c.next = null;
        } else {
            Node c = this.head;
            for (int i = 0; i < pos - 1; i++) {
                if (c == null) {
                    return;
                }
                c = c.next;
            }
            if (c.next != null) {
                Node old = c.next;
                c.next = c.next.next;
                old.next = null;
            }
        }

    }

    public int get(int pos) {
        if (pos < 0) {
            return -1;
        }

        Node c = this.head;
        int i = 0;
        while (i < pos && c != null) {
            c = c.next;
            ++i;
        }


        return c == null ? -1 : c.value;
    }

    @Override
    public String toString() {
        String r = "[";
        Node c = this.head;
        while (c != null) {
            r += c.value + ",";
            c = c.next;
        }
        r += "]";
        return r;
    }
}
