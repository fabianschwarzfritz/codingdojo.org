import static org.junit.Assert.*;

import org.junit.Test;

public class FQueueTest {
    
    @Test
    public void testPrint() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{1, 2, 3});
        assertEquals(q.toString(), "[1, 2, 3, ]");
    }

    @Test
    public void testEnqueue() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{1, 2, 3});
        q.enqueue(4);;
        assertEquals(q.toString(), "[1, 2, 3, 4, ]");
    }

    @Test
    public void testEnqueue2() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{});
        q.enqueue(4);
        assertEquals( "[4, ]", q.toString());
    }

    @Test
    public void testDequeue() {
        FQueue<Integer> q = new FQueue<Integer>(new Integer[]{1, 2});
        Integer r = q.dequeue();
        assertEquals(1, r.intValue());
        assertEquals("[2, ]", q.toString());
        r = q.dequeue();
        assertEquals(2, r.intValue());
        assertEquals("[]", q.toString());
        r = q.dequeue();
        assertEquals(null, r);
        assertEquals("[]", q.toString());
    }

    @Test
    public void testDequeueEmpty() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{});
        Integer r = q.dequeue();
        assertEquals(null, r);
        assertEquals("[]", q.toString());
    }

    @Test
    public void testPeek() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{1, 2});
        Integer r = q.peek();
        assertEquals(1, r.intValue());
        assertEquals("[1, 2, ]", q.toString());
    }


    @Test
    public void testPeekEmpty() {
        FQueue<Integer> q = new FQueue<>(new Integer[]{});
        Integer r = q.peek();
        assertEquals(null, r);
        assertEquals("[]", q.toString());
    }
}
