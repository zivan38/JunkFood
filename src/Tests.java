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

    /**
     * Этот метод подготовительный. Он всегда вызывается перед запуском любого теста или пачки тестов.
     * В нем удобно подготавливать (prepare) объекты, которые будут подвергаться множеству тестов. Например, подключить тестовую базу данных.
     *
     * В нашем случае показан пример создания заказа, состоящего из первого блюда списка блюд нашего меню.
     */
    @Before
    public void preparation(){
        o = new Order();
        List<Meal> menuList = new Menu().list();
        if (!menuList.isEmpty()) {
            o.addMeal(menuList.get(0));
        }
    }

    /**
     * Демонстрирует базовые возможности библиотеки тестирования JUnit.
     * Можно задавать несколько видов тестов.
     */
    @Test
    public void testExample(){
        //Проверка на истину булевого выражения
        assertTrue("Это все знают! Да или нет?!", 2+2 == 4);
        //Проверка на равенство объектов. Объекты сравниваются методом @see Object.equals
        assertEquals(new Integer(10), new Integer(10));
        //Проверка на неравенство. Да! 10 и "10" не равны. Это вам не JavaScript ;)
        assertNotEquals(10, "10");
        //Проверка на не пустоту
        assertNotNull(new Tests());
        //Проверка на пустоту
        assertNull(null);
        //Order создан, заранее заготовлен в методе prepare. Проверим его на не пустоту. Отрабатывает ли prepare???
        assertNotNull(o);
    }


    /**
     * Этот тест всегда проваливается. Пример реакции системы Unit Testing в случае некорректной реализации.
     * Эмулируется ошибка. На вход заведомо подаются некорректные данные.
     */
    @Test
    public void testFail() {
        assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
        assertEquals(new Integer(10), "10");
        assertNull(new Tests());
    }

    /*
        Тест проверяет кидание исключения IllegalArgumentException в случае, если в заказ добавляется что-то не из Меню.
    */
    @Test(expected= IllegalArgumentException.class)
    public void testNotInPrice(){
        new Order().addMeal(new Meal());
    }

    //-------------------------Ваши тесты --------------------------------



    //todo Test 1 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его наименования
    //todo Указать наименование при создании можно, изменить нельзя.
    //todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании




    //todo Test 2 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его цены
    //todo Проверьте, что указать цену при создании можно, изменить нельзя.
    //todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании

    @Test
    public void Test12Create() {
        Meal meal = new Meal("meal1", 12.5f);
        assertEquals("meal1", meal.getTitle());
        assertEquals(10f, meal.getPrice());
    }


    @Test
    public void Test12Equality() {
        Meal meal1 = new Meal("meal2", 7f);
        Meal meal2 = new Meal("meal2", 5f);
        assertEquals(meal1,meal2);

    }

    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов

    @Test
    public void Test3Menu() {
        Menu menu3 = new Menu();
        assertNotNull(menu3.list());
        assertTrue(menu3.list().size() >= 10);
        assertEquals(menu3.list(),menu3.list());
    }

    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException


    @Test
    public void Test3Order() {
        o = new Order();
        Menu menu3 = new Menu();
        o.addMeal(menu3.list().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test3OrderWrong() {
        o = new Order();
        o.addMeal(new Meal("meal3", 12.5f));
    }

    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов

    @Test
    public void Test4Price() {
        Order order4 = new Order();
        Menu menu4 = new Menu();
        assertEquals(new Float(0), order4.totalSum());
        Float price4 = menu4.list().get(0).getPrice();
        order4.addMeal(menu4.list().get(0));
        assertEquals(price4,order4.totalSum());


        Float price5 = menu4.list().get(1).getPrice() + menu4.list().get(2).getPrice();
        Order order5 = new Order();
        order5.addMeal(menu4.list().get(1));
        order5.addMeal(menu4.list().get(2));
        assertEquals(price5, order5.totalSum());
    }

    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно

    @Test
    public void Test5Repeat() {
        Order order5 = new Order();
        Menu menu5 = new Menu();
        Float price5 = menu5.list().get(2).getPrice();
        int a = 5;
        Float sum = price5*a;
        order.addMeals(menu5.list().get(2),count);
        assertEquals(sum,order5.totalSum());
    }

}
