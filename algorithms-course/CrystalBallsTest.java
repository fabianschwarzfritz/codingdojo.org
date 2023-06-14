import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrystalBallsTest {
    
    @Test
    public void testF1() {
        CrystalBalls c = new CrystalBalls();
        boolean[] input = new boolean[] {
            false, false, false, false, true, true
        };
        int re = c.distance(input);
        assertEquals(re, 4);
    }
}
