import FileProcessing.CreateVendorsList;
import Objects.Item;
import Objects.Vendor;
import Queries.FilterProductsOnCovers;
import Queries.FilterProductsOnDate;
import Queries.FilterProductsOnPostcode;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Run file parse, then create filtered Item lists based on what is fetched
        ArrayList<Vendor> vendorArrayList = new CreateVendorsList().parseFile(args[0]);
        ArrayList<Item> inTimeItems = new FilterProductsOnDate().filter(LocalDateTime.now(), vendorArrayList, args[1], args[2]);
        ArrayList<Item> inAddressItems = new FilterProductsOnPostcode().filter(args[3], vendorArrayList);
        ArrayList<Item> inCoverItems = new FilterProductsOnCovers().filter(Integer.parseInt(args[4]), vendorArrayList);

        ArrayList<Item> secondRound = new ArrayList<>();

        //Iterates through the first and second filtered lists, and adds Items that meet the requirements to an
        // intermediate list
        for (Item items : inTimeItems) {

            for (int i = 0; i < inAddressItems.size(); i++) if (items.equals(inAddressItems.get(i))) secondRound.add(items);

        }

        ArrayList<Item> result = new ArrayList<>();

        //Compare the intermediate list with the final filter, eliminating what does not meet requirements

        for (Item items : inCoverItems) {

            for (int i = 0; i < secondRound.size(); i++) if (items.equals(secondRound.get(i))) result.add(items);

        }

        //Print returned Items to the STD out
        for (Item items : result) System.out.println(items.getName()+";"+items.getAllergens());

    }
}
