package namazon.exceptions;

public class ProductNotAvailableException extends Exception{
    public ProductNotAvailableException (String errormsg){
        super(errormsg);

    }
}
