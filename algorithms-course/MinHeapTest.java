import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinHeapTest {

    @Test
    public void test1() {
        MinHeap<Integer> m = new MinHeap<>();
        m.insert(5);
        m.insert(1);
        m.insert(7);
        m.insert(12);
        m.insert(13);
        m.insert(6);
        assertEquals("1,5,6,12,13,7,", m.toString());
    }
    
}
