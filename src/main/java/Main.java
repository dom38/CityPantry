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

        ArrayList<Vendor> vendorArrayList = new CreateVendorsList().parseFile(args[0]);
        ArrayList<Item> inTimeItems = new FilterProductsOnDate().filter(LocalDateTime.now(), vendorArrayList, args[1], args[2]);
        ArrayList<Item> inAddressItems = new FilterProductsOnPostcode().filter(args[3], vendorArrayList);
        ArrayList<Item> inCoverItems = new FilterProductsOnCovers().filter(Integer.parseInt(args[4]), vendorArrayList);

        ArrayList<Item> secondRound = new ArrayList<>();

        for (Item items : inTimeItems) {

            for (int i = 0; i < inAddressItems.size(); i++) if (items.equals(inAddressItems.get(i))) secondRound.add(items);

        }

        ArrayList<Item> result = new ArrayList<>();

        for (Item items : inCoverItems) {

            for (int i = 0; i < secondRound.size(); i++) if (items.equals(secondRound.get(i))) result.add(items);

        }

        for (Item items : result) System.out.println(items.getName()+";"+items.getAllergens());

    }
}
