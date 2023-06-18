import java.util.LinkedList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> data = new LinkedList<>();

    public void insert(T t) {
        this.data.add(data.size(), t);
        this.heapifyUp(data.size() - 1);
    }

    public T pop() {
        if (this.data.size() == 0 ) {
            return null;
        }

        if (this.data.size() == 1 ) {
            T first = this.data.get(0);
            this.data = new LinkedList<>();
            return first;
        }

        T first = data.get(0);
        T last = data.get(data.size() - 1);
        data.set(0, last);
        data.remove(data.size() - 1);

        heapifyDown(0);

        return first;
    }

    private void heapifyUp(int idx) {
        if (idx == 0) {
            return;
        }

        T current = this.data.get(idx);
        T parent = this.data.get(parentIndex(idx));

        if (current.compareTo(parent) < 0) {
            this.data.set(idx, parent);
            this.data.set(parentIndex(idx), current);
            heapifyUp(parentIndex(idx));
        }
    }

    private void heapifyDown(int idx) {
        if (idx >= this.data.size()) {
            return;
        }

        int leftIdx = this.leftChildIndex(idx);
        int rightIdx = this.rightChildIndex(idx);

        if (leftIdx >= this.data.size()) {
            return;
        }

        T currValue = this.data.get(idx);
        T leftValue = this.data.get(leftIdx);
        T rightValue = this.data.get(rightIdx);

        if (leftValue.compareTo(rightValue) < 1 && currValue.compareTo(rightValue) < 1) {
            this.data.set(idx, rightValue);
            this.data.set(rightIdx, currValue);
            this.heapifyDown(rightIdx);
        } else if (rightValue.compareTo(leftValue) < 1 && currValue.compareTo(leftValue) < 1) {
            this.data.set(idx, leftValue);
            this.data.set(leftIdx, currValue);
            this.heapifyDown(leftIdx);
        }
    }


    private int parentIndex(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChildIndex(int idx) {
        return 2 * idx + 1;
    };

    private int rightChildIndex(int idx) {
        return 2 * idx + 2;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < this.data.size(); i++) {
            s.append(data.get(i));
            s.append(",");
        }
        return s.toString();
    }

}
