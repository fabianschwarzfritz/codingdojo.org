import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FLinkedListTest {

    @Test
    public void testInsert() {
        FLinkedList l = new FLinkedList();
        l.append(2);
        l.append(1);
        assertEquals("[2,1,]", l.toString());
    }

    @Test
    public void testGet() {
        FLinkedList l = new FLinkedList();
        l.append(1);
        l.append(2);
        l.append(3);
        assertEquals(1, l.get(0));
        assertEquals(3, l.get(2));
        // Yes, I know this is a sucky implementation
        assertEquals(-1, l.get(3));
        assertEquals(-1, l.get(-1));
    }

    @Test
    public void testLength() {
        FLinkedList l = new FLinkedList();
        assertEquals(0, l.length());
        l.append(1);
        assertEquals(1, l.length());
        l.append(1);
        assertEquals(2, l.length());
    }

}
