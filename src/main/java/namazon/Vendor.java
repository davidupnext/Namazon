package namazon;

import namazon.exceptions.ProductUnavailableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Vendor extends Account {
    private  String brandName;
    private Map<String, Integer> inventory;
    private List<Product> products;
    private Product[] showCase;
    private List<Order> orders;
    private int indexCount = 0;

    public Vendor(String brandName,String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);

        this.brandName = brandName;
        this.inventory = new HashMap<>();
        this.showCase = new Product[5];
        this.orders = new ArrayList<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public Product[] getShowCase() {
        return showCase;
    }

    public void setShowCase(Product[] showCase) {
        this.showCase = showCase;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addProduct(Product product){

        String productName= product.getName();
        if (inventory.containsKey(productName)) {
            int count = inventory.get(productName) + 1;
            inventory.put(productName, count);
        } else {
            inventory.put(productName, 1);
        }
    }

    public Boolean modifyProduct(Product product) {
        if (inventory.containsKey(product.getName())) {
            return true;
        }
        return false;
    }
    public Boolean removeProduct(Product product){
        if(inventory.containsKey(product)){
            inventory.remove(product);
            return true;
        }
        return false;
    }

    public Boolean cancelOrder(Order order){
        return true;
    }

    public void addProductToShowCase(Product product){
        if (showCase.length<=5){
            showCase[indexCount] = product;
            indexCount++;
        }

    }
    public  Product searchByCategory(ProductCategory productCategory){
        Product search = null;
        for (Product product : products){
            if(product.getCategory() ==productCategory){
                search = product;
            }
        }
        return search;
    }

    public Product searchByName(String name){
        /*Product search = null;

        if(inventory.containsKey(name)){
            search.getName();
        }*/
        Product search = null;
        for (Product product : products){
            if (product.getName() == name){
                search = product;
            }
        }
        return search;
    }

    private Boolean productInsideInventory(Product product){
        return inventory.containsKey(product);
    }
    public Product purchaseProduct(Product product, Address address) throws ProductUnavailableException {
        if (!productInsideInventory(product) ) throw new ProductUnavailableException("Product Unavailable");
        product.setAmount(product.getAmount() - 1); //Subtracts one because product is purchased
        Order order = new Order(product,address , OrderStatus.PENDING);
        orders.add(order);
        return product;
    }

    public List<Order> displayAllOrders(){

        return orders;
    }


}
