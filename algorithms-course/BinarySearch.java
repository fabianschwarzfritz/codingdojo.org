public class BinarySearch {

    public int search(int[] input, int search) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (input[middle] == search) {
                return middle;
            } else if (search > input[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return -1;
    }
}
