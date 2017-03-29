public class Meal {

    private String title;
    private float price;

    public Meal(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
        throw new UnsupportedOperationException();
    }


    public Float getPrice(){
        return price;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else {
            return false;
        }
    }
}
