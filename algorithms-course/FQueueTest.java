import static org.junit.Assert.*;

import org.junit.Test;

public class FQueueTest {
    
    @Test
    public void testPrint() {
        FQueue q = new FQueue(new int[]{1, 2, 3});
        assertEquals(q.toString(), "[1, 2, 3, ]");
    }

    @Test
    public void testEnqueue() {
        FQueue q = new FQueue(new int[]{1, 2, 3});
        q.enqueue(4);;
        assertEquals(q.toString(), "[1, 2, 3, 4, ]");
    }

    @Test
    public void testEnqueue2() {
        FQueue q = new FQueue(new int[]{});
        q.enqueue(4);
        assertEquals( "[4, ]", q.toString());
    }

    @Test
    public void testDequeue() {
        FQueue q = new FQueue(new int[]{1, 2});
        Integer r = q.dequeue();
        assertEquals(1, r.intValue());
        assertEquals("[2, ]", q.toString());
    }

    @Test
    public void testDequeueEmpty() {
        FQueue q = new FQueue(new int[]{});
        Integer r = q.dequeue();
        assertEquals(null, r);
        assertEquals("[]", q.toString());
    }

    @Test
    public void testPeek() {
        FQueue q = new FQueue(new int[]{1, 2});
        Integer r = q.peek();
        assertEquals(1, r.intValue());
        assertEquals("[1, 2, ]", q.toString());
    }


    @Test
    public void testPeekEmpty() {
        FQueue q = new FQueue(new int[]{});
        Integer r = q.peek();
        assertEquals(null, r);
        assertEquals("[]", q.toString());
    }
}
