import static org.junit.Assert.*;

import org.junit.Test;

public class FStackTest {

    @Test
    public void testPrint() {
        FStack s = new FStack(new int[]{1, 2, 3});
        assertEquals( "[1, 2, 3, ]", s.toString());
    }

    @Test
    public void testPush1() {
        FStack s = new FStack(new int[]{1, 2, 3});
        s.push(4);
        s.push(5);
        assertEquals( "[1, 2, 3, 4, 5, ]", s.toString());
    }

    @Test
    public void testPush2() {
        FStack s = new FStack(new int[]{});
        s.push(1);
        assertEquals( "[1, ]", s.toString());
    }
    
}
