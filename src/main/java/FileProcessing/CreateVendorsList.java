package FileProcessing;

import Objects.Item;
import Objects.Vendor;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreateVendorsList {

    public ArrayList<Vendor> parseFile(String filePath) {

        //Initialise the two empty arrays to store Vendors and Items
        ArrayList<Vendor> vendorList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        //Pattern to find postcodes and differentiate between Vendors and Items
        Pattern postcode = Pattern.compile(".*;[A-Z]{1,2}[0-9]{2}[A-Z]{2}.*");

        try {

            //Create a String list of the file input
            List<String> list = Files.readAllLines(new File(filePath).toPath(), Charset.defaultCharset() );

            for (String line : list) {

                Matcher matcher = postcode.matcher(line);

                //Add Vendor to vendorlist, if a postcode is in the entry
                if (line.contains(";") && matcher.matches()) {

                    String[] array = line.split(";");
                    vendorList.add(new Vendor(array[0], array[1], Integer.parseInt(array[2])));
                //If a Vendor is not found, Items are created and added to the item list
                } else if (line.contains(";")) {

                    String[] array = line.split(";");
                    itemList.add(new Item(array[0], new ArrayList<>(Arrays.asList(array[1].split(","))), array[2]));
                //Add the Item list to the created Vendor
                } else {

                    vendorList.get(vendorList.size()-1).setItems(itemList);
                    itemList = new ArrayList<>();

                }

            }

            //In case there is a preemptive EOF, make sure the last item is added to the vendor
            vendorList.get(vendorList.size()-1).setItems(itemList);


        } catch (FileNotFoundException fileNotFoundException) {

            fileNotFoundException.printStackTrace();

        } catch (IOException iOException) {

            iOException.printStackTrace();

        }

        return vendorList;
    }

}
