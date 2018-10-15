package Queries;

import FileProcessing.CreateVendorsList;
import Objects.Item;
import Objects.Vendor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FilterProductsOnCoversTest {

    private CreateVendorsList createVendorsList;
    private ArrayList<Vendor> vendorsList;
    private FilterProductsOnCovers filterProductsOnCovers;
    private int covers;

    @Before
    public void initialise () {

        createVendorsList = new CreateVendorsList();
        vendorsList = createVendorsList.parseFile("src/test/resources/exampleInput");
        filterProductsOnCovers = new FilterProductsOnCovers();

    }

    @Test
    public void testIfAllProductsAppearsWithOneCover () {

        covers = 1;
        ArrayList<Item> result = filterProductsOnCovers.filter(covers, vendorsList);
        Assert.assertEquals(result.size(), 5);

    }

    @Test
    public void testIfFourProductsAppearsWithTwentyOneCovers () {

        covers = 21;
        ArrayList<Item> result = filterProductsOnCovers.filter(covers, vendorsList);
        Assert.assertEquals(result.size(), 4);

    }

    @Test
    public void testIfTwoProductsAppearsWithFourtyOneCovers () {

        covers = 41;
        ArrayList<Item> result = filterProductsOnCovers.filter(covers, vendorsList);
        Assert.assertEquals(result.size(), 2);

    }

    @Test
    public void testIfOneProductAppearsWithOneHundredAndOneCovers () {

        covers = 101;
        ArrayList<Item> result = filterProductsOnCovers.filter(covers, vendorsList);
        Assert.assertEquals(result.size(), 1);

    }

    @Test
    public void testIfNoProductAppearsWithOneBillionCovers () {

        covers = 100000000;
        ArrayList<Item> result = filterProductsOnCovers.filter(covers, vendorsList);
        Assert.assertEquals(result.size(), 0);

    }
}
