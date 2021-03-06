package Queries;

import Objects.Item;
import Objects.Vendor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FilterProductsOnDate {


    public ArrayList<Item> filter(LocalDateTime currentTime, ArrayList<Vendor> vendorList, String inputDate, String inputTime) {

        ArrayList<Item> result = new ArrayList<>();
        //Transform required date and time to Java LocalDateTime object, and convert to EpochMillis for easy comparison
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        long requiredTime = LocalDateTime.parse(inputDate + " " + inputTime, formatter).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        //Get all items from vendorList
        for (Vendor vendor : vendorList) {

            result.addAll(vendor.getItems());

        }

        ArrayList<Item> inTimeItems = new ArrayList<>();

        //Transform current time plus minimum lead time to EpochMillis, and compare the minimum time to the required
        // time, adding items that meet the minimum requirement to a list that is returned
        for (int i = 0; i < result.size(); i++) {

            long minimumTime = currentTime.plusHours(
                    Long.parseLong(result.get(i).getAdvanceTime().replaceFirst("h","")))
                    .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            if (minimumTime < requiredTime) inTimeItems.add(result.get(i));

        }

        return inTimeItems;

    }
}
