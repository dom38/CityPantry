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

        ArrayList<Vendor> vendorList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        Pattern postcode = Pattern.compile(".*;[A-Z]{1,2}[0-9]{2}[A-Z]{2}.*");

        try {

            List<String> list = Files.readAllLines(new File(filePath).toPath(), Charset.defaultCharset() );

            for (String line : list) {

                Matcher matcher = postcode.matcher(line);

                if (line.contains(";") && matcher.matches()) {

                    String[] array = line.split(";");
                    vendorList.add(new Vendor(array[0], array[1], Integer.parseInt(array[2])));

                } else if (line.contains(";")) {

                    String[] array = line.split(";");
                    itemList.add(new Item(array[0], new ArrayList<>(Arrays.asList(array[1].split(","))), array[2]));

                } else {

                    vendorList.get(vendorList.size()-1).setItems(itemList);
                    itemList = new ArrayList<>();

                }

            }

            vendorList.get(vendorList.size()-1).setItems(itemList);


        } catch (FileNotFoundException fileNotFoundException) {

            fileNotFoundException.printStackTrace();

        } catch (IOException iOException) {

            iOException.printStackTrace();

        }
        return vendorList;
    }

}
