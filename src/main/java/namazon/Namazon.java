package namazon;


import java.util.List;

public class Namazon {

    private List<Vendor> vendors;
   private List<Customer> customers;
   private String email;
   private String password;



    public Account signIn(String email, String password) {
       Account logInAccount = null;
        for (Account account1 : vendors){
            if (account1.getEmail().equals(email) && account1.getPassword().equals(password)){
                logInAccount = account1;
            }
        }
        for(Account account1 : customers){
            if (account1.getEmail().equals(email) && account1.getPassword().equals(password)){
                logInAccount = account1;
            }
        }
        return logInAccount;
    }
    public Vendor signUpAsVendor(String brandName, String firstName, String lastName,String email, String password){
        Vendor vendor = new Vendor(brandName, firstName, lastName,email, password);
        vendors.add(vendor);
        return vendor;
    }

    public Customer signUpAsCustomer(String firstName, String lastName, String email, String password, Address address){
        Customer customer = new Customer(firstName,lastName,email,password, address);
        customers.add(customer);
        return customer;
    }

    public Vendor selectVendor(Vendor vendor) {

        for (Vendor i : vendors) {
            if (i == vendor) {
                return vendor;
            }

        }
        return vendor;
    }

}
