package ch.wiss.m294295.exception.LoadException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Product} objects could not be loaded.
 *
 * @Author Michael
 *
 */
public class ProductLoadException extends RuntimeException{
    public ProductLoadException(){
        super("Product could not be loaded.");
    }
}
