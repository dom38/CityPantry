package FileProcessing;

import Objects.Vendor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CreateVendorsListTest {

    private String filePath;
    private CreateVendorsList createVendorsList;

    @Before
    public void initialise () {

        filePath = "src/test/resources/exampleInput";
        createVendorsList = new CreateVendorsList();

    }

    @Test
    public void testThatVendorObjectIsCreated () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals( vendorArrayList.get(0).getClass(), Vendor.class);

    }

    @Test
    public void testThatFirstVendorHasCorrectPostcode () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(0).getPostcode(), "E32NY");

    }

    @Test
    public void testThatSecondVendorHasCorrectName () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(1).getName(), "Wholegrains");

    }

    @Test
    public void testThatThirdVendorHasCorrectCovers () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(2).getMaxCovers(), 40);

    }

    @Test
    public void testThatFirstItemHasCorrectAllergens () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(0).getItems().get(0).getAllergens().get(0), "nuts");

    }

    @Test
    public void testThatSecondItemHasCorrectAdvanceTime () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(1).getItems().get(0).getAdvanceTime(), "24h");

    }

    @Test
    public void testThatSecondItemForThirdVendorHasCorrectName () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(2).getItems().get(1).getName(), "Breakfast");

    }

    @Test
    public void testThatFirstItemForThirdVendorContainsNoAllergens () {

        ArrayList<Vendor> vendorArrayList = createVendorsList.parseFile(filePath);
        Assert.assertEquals(vendorArrayList.get(2).getItems().get(0).getAllergens().get(0), "");

    }

}
