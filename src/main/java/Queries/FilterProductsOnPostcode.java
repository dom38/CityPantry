package Queries;

import Objects.Item;
import Objects.Vendor;

import java.util.ArrayList;

public class FilterProductsOnPostcode {

    public ArrayList<Item> filter(String postcode, ArrayList<Vendor> vendorsList) {

        //Get first one or two letters from the require postcode and use for comparison

        String area = postcode.substring(0,2).replaceAll("[0-9]", "");
        ArrayList<Item> result = new ArrayList<>();

        //Iterate through the fetched list from the vendorsList and check the postcode vs required area
        // Add any items with the required postcode to a list and return the list

        for (Vendor vendors : vendorsList) {

            if ((vendors.getPostcode().substring(0,2).replaceAll("[0-9]", "")).equals(area)) {

                result.addAll(vendors.getItems());

            }

        }

        return result;

    }
}
