import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

    public void testBinary(int needle, int expected) {
        int[] input = new int[] {
            2, 4, 6, 8, 10
        };
        BinarySearch search = new BinarySearch();
        int index = search.search(input, needle);
        assertEquals(expected, index);
    }

    @Test
    public void testF1() {
        testBinary(2, 0);
        testBinary(10, 4);
        testBinary(1, -1);
    }
}

