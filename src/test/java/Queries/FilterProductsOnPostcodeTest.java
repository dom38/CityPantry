package Queries;

import FileProcessing.CreateVendorsList;
import Objects.Item;
import Objects.Vendor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FilterProductsOnPostcodeTest {

    private FilterProductsOnPostcode filterProductsOnPostcode;
    private CreateVendorsList createVendorsList;
    private ArrayList<Vendor> vendorsList;
    private String postcode;

    @Before
    public void initialise () {

        filterProductsOnPostcode = new FilterProductsOnPostcode();
        createVendorsList = new CreateVendorsList();
        vendorsList = createVendorsList.parseFile("src/test/resources/exampleInput");

    }

    @Test
    public void getProductsInEast () {

        postcode = "E35YH";
        ArrayList<Item> result = filterProductsOnPostcode.filter(postcode, vendorsList);
        Assert.assertEquals(result.size(), 1);

    }

    @Test
    public void getProductsInEastCentral () {

        postcode = "EC35YH";
        ArrayList<Item> result = filterProductsOnPostcode.filter(postcode, vendorsList);
        Assert.assertEquals(result.size(), 1);

    }

    @Test
    public void getProductsInNorthWest () {

        postcode = "NW35YH";
        ArrayList<Item> result = filterProductsOnPostcode.filter(postcode, vendorsList);
        Assert.assertEquals(result.size(), 2);

    }

    @Test
    public void getProductsInSouthWest () {

        postcode = "SW35YH";
        ArrayList<Item> result = filterProductsOnPostcode.filter(postcode, vendorsList);
        Assert.assertEquals(result.size(), 1);

    }

}
