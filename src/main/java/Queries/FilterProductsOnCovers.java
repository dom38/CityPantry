package Queries;

import Objects.Item;
import Objects.Vendor;

import java.util.ArrayList;

public class FilterProductsOnCovers {

    public ArrayList<Item> filter(int covers, ArrayList<Vendor> vendorsList) {

        ArrayList<Item> result = new ArrayList<>();

        for (Vendor vendors : vendorsList) {

            if (vendors.getMaxCovers() > covers) {

                result.addAll(vendors.getItems());

            }

        }

        return result;

    }
}
