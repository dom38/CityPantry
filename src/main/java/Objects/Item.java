package Objects;

import java.time.LocalTime;
import java.util.ArrayList;

public class Item {

    String name;
    ArrayList<String> allergens;
    String advanceTime;

    public String getName() {
        return name;
    }

    public ArrayList<String> getAllergens() {
        return allergens;
    }

    public String getAdvanceTime() {
        return advanceTime;
    }

    public Item(String name, ArrayList<String> allergens, String advanceTime) {

        this.name = name;
        this.allergens = allergens;
        this.advanceTime = advanceTime;

    }
}
