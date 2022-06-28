import namazon.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    @DisplayName("Parameterized Constructor Test")
    public void constructorTest01(){
        Address address = new Address("15 Grove Street", "Martin Luther St", "Kentucky State","Chicago" );
        String expected = "15 Grove Street Martin Luther St Kentucky State Chicago";
        String street = address.getStreet();
        String unit = address.getUnit();
        String city = address.getCity();
        String state = address.getState();
        String actual = String.format("%s %s %s %s", street,unit,city,state);
        Assertions.assertEquals(expected, actual);
    }
}
