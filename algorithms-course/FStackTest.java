import static org.junit.Assert.*;

import org.junit.Test;

public class FStackTest {

    @Test
    public void testPrint() {
        FStack<Integer> s = new FStack<>(new Integer[]{1, 2, 3});
        assertEquals( "[1, 2, 3, ]", s.toString());
    }

    @Test
    public void testPush1() {
        FStack<Integer> s = new FStack<>(new Integer[]{1, 2, 3});
        s.push(4);
        s.push(5);
        assertEquals( "[1, 2, 3, 4, 5, ]", s.toString());
    }

    @Test
    public void testPush2() {
        FStack<Integer> s = new FStack<>(new Integer[]{});
        s.push(1);
        assertEquals( "[1, ]", s.toString());
    }

    @Test
    public void testPop1() {
        FStack<Integer> s = new FStack<>(new Integer[]{1, 2});
        Integer r = s.pop();
        assertEquals(2, r.intValue());
        assertEquals("[1, ]", s.toString());
    }

    @Test
    public void testPop2() {
        FStack<Integer> s = new FStack<>(new Integer[]{});
        Integer r = s.pop();
        assertEquals(null, r);
        assertEquals("[]", s.toString());
    }
    
    @Test
    public void testPeek() {
        FStack<Integer> s = new FStack<>(new Integer[]{});
        Integer r = s.peek();
        assertEquals(null, r);
        assertEquals("[]", s.toString());
    }
    
    @Test
    public void testPeek1() {
        FStack<Integer> s = new FStack<>(new Integer[]{1, 2});
        Integer r = s.peek();
        assertEquals(2, r.intValue());
        assertEquals("[1, 2, ]", s.toString());
    }
    
}
