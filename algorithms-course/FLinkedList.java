import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FLinkedList<T> {

    static class Node<T> {
        T value;
        Node<T> next;
    }

    private Node<T> head;
    int length;

    public int length() {
        return this.length;
    }

    public void append(T item) {
        ++length;
        if (this.head == null) {
            this.head = new Node<T>();
            this.head.value = item;
        } else {
            Node<T> c = this.head;
            while (c.next != null) {
                c = c.next;
            };
            c.next = new Node<T>();
            c.next.value = item;
        }
    }
    
    public void removeAt(int pos) {
        if(pos < 0) {
            return;
        } else if (pos == 0) {
            Node<T> c = this.head;
            this.head = this.head.next;
            c.next = null;
        } else {
            Node<T> c = this.head;
            for (int i = 0; i < pos - 1; i++) {
                if (c == null) {
                    return;
                }
                c = c.next;
            }
            if (c.next != null) {
                Node<T> old = c.next;
                c.next = c.next.next;
                old.next = null;
            }
        }

    }

    public T get(int pos) {
        if (pos < 0) {
            return null;
        }

        Node<T> c = this.head;
        int i = 0;
        while (i < pos && c != null) {
            c = c.next;
            ++i;
        }


        return c == null ? null : c.value;
    }

    public T[] toArray() {
        // Yes I know this can explode
        T f = this.get(0);
        T[] t = (T[]) Array.newInstance(f.getClass(), this.length);

        for (int i = 0; i < this.length; i++) {
            t[i] = this.get(i);
        }
        return t;
    }

    @Override
    public String toString() {
        String r = "[";
        Node<T> c = this.head;
        while (c != null) {
            r += c.value + ",";
            c = c.next;
        }
        r += "]";
        return r;
    }
}
