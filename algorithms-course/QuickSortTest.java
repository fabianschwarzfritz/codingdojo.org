import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickSortTest {

    private void test(int[] in, int[] exp) {
        QuickSort q = new QuickSort();
        q.sort(in);
        assertEquals(exp.length, in.length);
        assertArrayEquals(exp, in);
    }

    @Test
    public void testQuickSort() {
        int[] in = new int[] {4,8,3,5,32,4,4,5,7,99,64,36};
        int[] exp = new int[]{
            3,4,4,4,5, 5,7,8,32,36,64,99
        };
        this.test(in, exp);
    }

    @Test
    public void testQuickSortEmpty() {
        this.test(new int[]{}, new int[]{});
    }

    @Test
    public void testQuickSortPerf() {
        int[] in = generateArray(10000);
        QuickSort q = new QuickSort();
        long start = System.nanoTime();
        q.sort(in);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println((stop - start) / 1000 + " ms");
    }
    
    private int[] generateArray(int times) {
        int[] result = new int[times];
        for (int i = 0; i < times; i++) {
            int r = (int) Math.random() * 100000;
            result[i] = r;
        }
        return result;
    }
}
