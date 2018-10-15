package Objects;

import java.util.ArrayList;
import java.util.Objects;

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

    //Comparison is required to make sure that queries can be compared to each other, so I added a custom equals
    // and hashcode method to make sure that the same items with different hashcodes are still equivalent

    @Override
    public boolean equals (Object item) {

        if (item == this) return true;
        if (!(item instanceof Item)) return false;
        Item equalsItem = (Item) item;
        return advanceTime == equalsItem.advanceTime &&
                Objects.equals(name, equalsItem.name) &&
                Objects.equals(allergens, equalsItem.allergens);

    }

    @Override
    public int hashCode () {

        return Objects.hash(name, allergens, advanceTime);

    }
}
