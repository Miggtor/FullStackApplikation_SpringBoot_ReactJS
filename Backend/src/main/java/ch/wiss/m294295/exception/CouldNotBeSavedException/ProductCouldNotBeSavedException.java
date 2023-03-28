package ch.wiss.m294295.exception.CouldNotBeSavedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Product} objects could not be saved.
 *
 * @Author Michael
 *
 */
public class ProductCouldNotBeSavedException extends RuntimeException {
    public ProductCouldNotBeSavedException(String ProductName){
        super("The Product with the name"+ ProductName +"could not be saved");
    }
}
