import namazon.Account;
import namazon.Customer;
import namazon.Vendor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NamazonTest {
    @Test
    @DisplayName("COnstructor Test")
    public void constructorTest(){

        Vendor vendor = new Vendor("Under Armor", "David", "Adeleke", "davidadeleke@UA.com", "UABRANDS");
        Vendor vendor1 = new Vendor("Nike", "Rashon", "Morris", "RashonMorris@nike.com", "NIKETECH");
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        vendors.add(vendor1);
    }
}
