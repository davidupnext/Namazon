package namazon.exceptions;

public class ProductUnavailableException extends Exception{
    public ProductUnavailableException(String errormsg){
        super(errormsg);

    }
}
