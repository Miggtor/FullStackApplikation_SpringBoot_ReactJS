package ch.wiss.m294295.exception.CouldNotBeDeletedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Product} objects could not be deleted.
 *
 * @Author Michael
 *
 */
public class ProductCouldNotBeDeletedException extends RuntimeException{
    public ProductCouldNotBeDeletedException(){
        super("The Product could not be deleted");
    }
}
