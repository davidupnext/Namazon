import namazon.Product;
import namazon.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    @DisplayName("Concstructor Test")

    public void constructorTest01(){
        Product product = new Product("Football" , ProductCategory.ATHLETICS, 120.0);
        String expected = "name='Football', category=ATHLETICS, price=120.0";
        String actual = product.toString();
        Assertions.assertEquals(expected, actual);
    }
}
