package Queries;

import Objects.Item;
import Objects.Vendor;

import java.util.ArrayList;

public class FilterProductsOnCovers {

    public ArrayList<Item> filter(int covers, ArrayList<Vendor> vendorsList) {

        ArrayList<Item> result = new ArrayList<>();

        //Iterate through the fetched list from the vendorsList and check the covers vs required covers
        // Add any items with the required covers to a list and return the list
        for (Vendor vendors : vendorsList) {

            if (vendors.getMaxCovers() > covers) {

                result.addAll(vendors.getItems());

            }

        }

        return result;

    }
}
