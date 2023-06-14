import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {
    
    @Test
    public void testBubbleSort() {
        int[] in = new int[]{
            1, 3, 7, 4, 2
        };
        BubbleSort s = new BubbleSort();
        int[] r = s.sort(in);
        assertArrayEquals(
            new int[]{ 1, 2, 3, 4, 7},
            r
        );
    }
}
