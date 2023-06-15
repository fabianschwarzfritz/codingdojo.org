
class QuickSort {
    public int[] sort(int[] in) {
        this.recurse(in, 0, in.length - 1);
        return in;
    }

    private void recurse(int[] in, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int p = in[hi];
        int idx = lo - 1;
        // [3 7 5 4]

        for (int i = lo; i < hi; i++) {
            if (in[i] <= p) {
                ++idx;
                this.swap(in, idx, i);
            }
        }

        // We excluded the pivot element
        // so we have to swap this one as well
        idx++;
        in[hi] = in[idx];
        in[idx] = p;

        // idx is now the pivot index.
        this.recurse(in, lo, idx - 1);
        this.recurse(in, idx + 1, hi);
    }

    private void swap(int[] in, int from, int to) {
        int tmp = in[from];
        in[from] = in[to];
        in[to] = tmp;
    }
}
