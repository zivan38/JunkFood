

public class Order {

     private List<Meal> mealList;

     public Order() {
     mealList = new ArrayList<>();
     }

    public void addMeal(Meal meal){
        if (Menu.containsMeal(meal)){
            if (!(meal == null)) {
                mealList.add(meal);
            }
        } else throw new IllegalArgumentException();
    }
        throw new UnsupportedOperationException();
    }


    public void addMeals(Meal meal, int count){
        if (Menu.containsMeal(meal)){
            if (meal != null) {
                for (int i=0;i<count;i++){
                    mealList.add(meal);}
            }
        } else throw new IllegalArgumentException();
    }




    public Float totalSum(){
        Float sum = 0.0f;
        for(Meal e : mealList){
            sum+= e.getPrice();
        }
        return sum;
    }
}
