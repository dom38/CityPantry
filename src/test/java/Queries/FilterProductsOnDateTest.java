package Queries;

import FileProcessing.CreateVendorsList;
import Objects.Item;
import Objects.Vendor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FilterProductsOnDateTest {

    private FilterProductsOnDate filterProductsOnDate;
    private ArrayList<Vendor> vendorList;
    private String inputDate;
    private String inputTime;
    private LocalDateTime currentTime;

    @Before
    public void initilise() {

        filterProductsOnDate = new FilterProductsOnDate();
        vendorList = new CreateVendorsList().parseFile("src/test/resources/exampleInput");
        currentTime = LocalDateTime.now();

    }

    @Test
    public void testThatAllVendorsAppearIfGivenAeons () {

        currentTime = LocalDateTime.of(1,1,1,0,1);
        inputTime = "11:00";
        inputDate = "24/12/18";
        ArrayList<Item> result = filterProductsOnDate.filter(currentTime, vendorList, inputDate, inputTime);
        Assert.assertEquals(result.size(), 5);

    }

    @Test
    public void testThatTwoProductsAppearWith12hLeadTime () {

        inputTime = "14:00";
        inputDate = "15/10/18";
        currentTime = LocalDateTime.of(2018,10,15,1,0);
        ArrayList<Item> result = filterProductsOnDate.filter(currentTime, vendorList, inputDate, inputTime);
        Assert.assertEquals(result.size(), 2);

    }

    @Test
    public void testThatFourProductsAppearWith24hLeadTime () {

        inputTime = "02:00";
        inputDate = "15/10/18";
        currentTime = LocalDateTime.of(2018,10,14,1,0);
        ArrayList<Item> result = filterProductsOnDate.filter(currentTime, vendorList, inputDate, inputTime);
        Assert.assertEquals(result.size(), 4);

    }

    @Test
    public void testThatFiveProductsAppearWith36hLeadTime () {

        inputTime = "02:00";
        inputDate = "15/10/18";
        currentTime = LocalDateTime.of(2018,10,13,1,0);
        ArrayList<Item> result = filterProductsOnDate.filter(currentTime, vendorList, inputDate, inputTime);
        Assert.assertEquals(result.size(), 5);

    }

    @Test
    public void testThatZeroProductsAppearWith11hLeadTime () {

        inputTime = "12:00";
        inputDate = "15/10/18";
        currentTime = LocalDateTime.of(2018,10,15,1,0);
        ArrayList<Item> result = filterProductsOnDate.filter(currentTime, vendorList, inputDate, inputTime);
        Assert.assertEquals(result.size(), 0);

    }

}
