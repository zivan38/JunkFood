import java.util.Collections;
import java.util.List;

public class Menu {
    private static List<Meal> list;
    public Menu() {
        list = new ArrayList<>();
        list.add(new Meal("meal1",1f));
        list.add(new Meal("meal2",2f));
        list.add(new Meal("meal3",3f));
        list.add(new Meal("meal4",3.5f));
        list.add(new Meal("meal5",4f));
        list.add(new Meal("meal6",5f));
        list.add(new Meal("meal7",6ff));
        list.add(new Meal("meal8",10f));
        list.add(new Meal("meal9",12.5f));
        list.add(new Meal("meal10",2.5f));
        list.add(new Meal("meal11",0.5f));
        list.add(new Meal("meal12",10f));
    }

    public List<Meal> list(){
        return Collections.unmodifiableList(list);
    }

    public static boolean containsMeal(Meal meal){
        return list.contains(meal);
    }
}
