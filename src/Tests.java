import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * ТЕСТЫ!!! TestDrivenDevelopment rules!!!
 */


public class Tests {
    Order o=null;

    @Before
    public void preparation(){
        o = new Order();
        List<Meal> menuList = new Menu().list();
        if (!menuList.isEmpty()) {
            o.addMeal(menuList.get(0));
        }
    }

    @Test
    public void testExample(){
        assertTrue("Это все знают! Да или нет?!", 2+2 == 4);
        assertEquals(new Integer(10), new Integer(10));
        assertNotEquals(10, "10");
        assertNotNull(new Tests());
        assertNull(null);
        //Order created in prepare method
        assertNotNull(o);
    }

    @Test
    public void testFail() {
        assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
        assertEquals(new Integer(10), "10");
        assertNull(new Tests());
    }

    /*
        Тест проверяет кидание исключения в случае, если в заказ добавляется что-то не из Меню.
    */
    @Test(expected= IllegalArgumentException.class)
    public void testNotInPrice(){
        new Order().addMeal(new Meal());
    }
}
