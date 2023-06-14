public class BubbleSort {
    // n^2 algorithm
    public int[] sort(int[] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length - i - 1; j++) {
                if (in[j] > in[j+1]) {
                    int t = in[j+1];
                    in[j+1] = in[j];
                    in[j] = t;
                }
            }
        }

        return in;
    }
}
