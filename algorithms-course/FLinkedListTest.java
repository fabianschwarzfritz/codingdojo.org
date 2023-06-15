import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FLinkedListTest {

    @Test
    public void testInsert() {
        FLinkedList<Integer> l = new FLinkedList<>();
        l.append(2);
        l.append(1);
        assertEquals("[2,1,]", l.toString());
    }

    @Test
    public void testGet() {
        FLinkedList<Integer> l = new FLinkedList<>();
        l.append(1);
        l.append(2);
        l.append(3);
        assertEquals(1, l.get(0).intValue());
        assertEquals(3, l.get(2).intValue());
        // Yes, I know this is a sucky implementation
        assertEquals(null, l.get(3));
        assertEquals(null, l.get(-1));
    }

    @Test
    public void testDelete() {
        FLinkedList<Integer> l = new FLinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i);
        };
        l.removeAt(2);
        assertEquals("[0,1,3,4,5,6,7,8,9,]", l.toString());
        l.removeAt(7);
        assertEquals("[0,1,3,4,5,6,7,9,]", l.toString());
        l.removeAt(-1);
        assertEquals("[0,1,3,4,5,6,7,9,]", l.toString());
        l.removeAt(6);
        assertEquals("[0,1,3,4,5,6,9,]", l.toString());
        l.removeAt(6);
        assertEquals("[0,1,3,4,5,6,]", l.toString());
    }

    @Test
    public void testLength() {
        FLinkedList<Integer> l = new FLinkedList<>();
        assertEquals(0, l.length());
        l.append(1);
        assertEquals(1, l.length());
        l.append(1);
        assertEquals(2, l.length());
    }

}
