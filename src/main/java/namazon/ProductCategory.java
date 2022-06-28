package namazon;

public enum ProductCategory {

    ELECTRONICS("Electronics"), ATHLETICS("Athletics"), CLOTHING("Clothing"), HOME_APPLIANCES("Home_Appliances");
    private String name;
    ProductCategory (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
