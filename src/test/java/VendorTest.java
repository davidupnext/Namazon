import namazon.Order;
import namazon.Product;
import namazon.ProductCategory;
import namazon.Vendor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendorTest {

    private Vendor vendor;
    private Product product;
    private Product product2;
@BeforeEach
public void setup(){
        Vendor vendor = new Vendor("Under Armor", "David", "Adeleke", "davidadeleke@UA.com", "UABRANDS");
        Product product = new Product("Football" , ProductCategory.ATHLETICS, 120.0);
        Product product2 = new Product("Apple Watch" , ProductCategory.ELECTRONICS, 180.0);
        }

    private HashMap<Product,Integer> inventory = new HashMap<>();
    private Product[] showCase = new Product[5];
    private List<Order> order = new ArrayList<>();

    @Test
    @DisplayName("AddProduct")
    public void AddProductTest(){

        int expected =2;

        vendor.addProduct(product);
        vendor.addProduct(product2);
        int actual = vendor.getInventory().size();
        Assertions.assertEquals(expected,actual);

    }

   // @Test
    //@DisplayName("Test")

}
