import java.util.ArrayList;

public class Inventory {

    private ArrayList<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void showItems(){
        System.out.println(items);
    }

}
