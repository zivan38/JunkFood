import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladimir on 14.04.2015.
 */


public class Tests {
    @Test
    public void testExample(){
        assertTrue("Это все знают! Да или нет?!", 2+2 == 4);
        assertEquals(new Integer(10), new Integer(10));
        assertNotNull(new Tests());
    }

    @Test
    public void testFail() {
        assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
        assertEquals(new Integer(10), "10");
        assertNull(new Tests());
    }
}
