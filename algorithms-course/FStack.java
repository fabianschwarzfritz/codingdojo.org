import java.util.ArrayList;

public class FStack {
    
    public static class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    FStack(int[] initial) {
        if (initial.length != 0) {
            Node t = new Node(initial[0]);
            for (int i = 1; i < initial.length; i++) {
                Node n = new Node(initial[i]);
                n.next = t;
                t = n;
            }
            this.head = t;
        }
    }

    public void push(int i) {
        Node n = new Node(i);
        if (this.head != null) {
            n.next = this.head;
        }
        this.head = n;
    }

    @Override
    public String toString() {
        // I know, I'm using array list here....
        ArrayList<Node> result = new ArrayList<>();
        Node t = this.head;
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
