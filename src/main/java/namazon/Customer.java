package namazon;
import java.util.ArrayList;
import java.util.List;
public class Customer extends Account{


    private double money;
    private List<Order> orders;
    private Address address;
    public Customer(String firstName, String lastName, String email, String password, Address address){
        super(firstName, lastName, email, password);
        this.orders =new ArrayList<>();
        this.address = this.address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
