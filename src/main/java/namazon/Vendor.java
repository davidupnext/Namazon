package namazon;

import namazon.exceptions.NotInInventoryException;
import namazon.exceptions.ProductUnavailableException;

import java.util.*;

public class Vendor extends Account {
    private  String brandName;
    private Map<Product, Integer> inventory;
    private List<Product> products;
    private Product[] showCase;
    private List<Order> orders;


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

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Product, Integer> inventory) {
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
            inventory.put(product, count);
        } else {
            inventory.put(product, 1);
        }
    }

   /* public Boolean modifyProduct(Product product,String name) {
        if (inventory.containsKey(product.getName())) {
            product.setName(name);
            inventory.put(product);
            return true;
        }
        return false;
    }*/

    public Boolean removeProduct(Product product){
        if(inventory.containsKey(product)){
            inventory.remove(product);
            return true;
        }
        return false;
    }

    private Boolean insideInventory(Product product){
        return inventory.containsKey(product);
    }
    public Order placeAnOrder(Product product, Address destination) throws NotInInventoryException {
        if(!insideInventory(product)) throw new NotInInventoryException();
        Order order = new Order(product, destination, OrderStatus.PENDING);
        removeProductFromInventory(product);
        orders.add(order);
        return order;
    }
    public Boolean cancelOrder(Order order){
        if(order == null) return false;
        if(checkIfOrderExistsAndHasShipped(order))
            return orders.remove(order);
        return false;
    }

    private Boolean checkIfOrderExistsAndHasShipped(Order order){
        return orders.stream().anyMatch(placedOrder -> placedOrder.getId()
                .equals(order.getId()) &&
                placedOrder.getStatus() != OrderStatus.SHIPPED);
    }

    public Boolean removeProductFromInventory(Product product){
        if(insideInventory(product)) {
            inventory.remove(product);
            return true;
        }
        return false;
    }

    public void addProductToShowcase(Product product, Integer position){
        if(position < 0 || position > 4) throw new IndexOutOfBoundsException();
        showCase[position] = product;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(brandName, vendor.brandName) && Objects.equals(inventory, vendor.inventory) && Arrays.equals(showCase, vendor.showCase) && Objects.equals(orders, vendor.orders);
    }
}
