import FileProcessing.CreateVendorsList;
import Objects.Vendor;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class Main {

    public static void main(@NotNull String[] args) {

        ArrayList<Vendor> vendorArrayList = new CreateVendorsList().parseFile(args[0]);

    }
}
