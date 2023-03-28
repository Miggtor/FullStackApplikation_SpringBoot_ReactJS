package ch.wiss.m294295.exception.CouldNotBeDeletedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.ShopOrder} objects could not be deleted.
 *
 * @Author Michael
 *
 */
public class ShopOrderCouldNotBeDeletedException extends RuntimeException{
    public ShopOrderCouldNotBeDeletedException(){
        super("The ShopOrder could not be deleted");
    }
}
