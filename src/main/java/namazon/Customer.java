package namazon;

public class Customer extends Account{


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public Customer(String firstName, String lastName, String email, String password){
        super(firstName, lastName, email, password);
    }
}
