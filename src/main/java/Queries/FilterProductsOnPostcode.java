package Queries;

import Objects.Item;
import Objects.Vendor;

import java.util.ArrayList;

public class FilterProductsOnPostcode {

    public ArrayList<Item> filter(String postcode, ArrayList<Vendor> vendorsList) {

        String area = postcode.substring(0,2).replaceAll("[0-9]", "");
        ArrayList<Item> result = new ArrayList<>();

        for (Vendor vendors : vendorsList) {

            if ((vendors.getPostcode().substring(0,2).replaceAll("[0-9]", "")).equals(area)) {

                result.addAll(vendors.getItems());

            }

        }

        return result;

    }
}
