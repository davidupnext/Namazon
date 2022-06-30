package namazon;

public class Product {
    private static Long idCount = 1L;
    private Long id;
    private String name;
    private ProductCategory category;
    private Double price;
    private Integer amount;

    public Product(String name, ProductCategory category, Double price) {
        this.id = idCount++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.amount = 1;
    }

    public Integer getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price ;
    }
}
