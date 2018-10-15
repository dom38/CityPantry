package Objects;

import java.util.ArrayList;

public class Vendor {

    String name;
    String postcode;
    int maxCovers;
    ArrayList<Item> items;

    public String getName() {
        return name;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getMaxCovers() {
        return maxCovers;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Vendor(String name, String postcode, int maxCovers) {

        this.name = name;
        this.postcode = postcode;
        this.maxCovers = maxCovers;

    }
}
