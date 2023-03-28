package ch.wiss.m294295.exception.CouldNotBeUpdatedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.ShopOrder} objects could not be updated.
 *
 * @Author Michael
 *
 */
public class ShopOrderCouldNotBeUpdatedException extends RuntimeException{
    public ShopOrderCouldNotBeUpdatedException(int ShopOrderId){
        super("The ShopOrder with the Id"+ShopOrderId+"could not be updated");
    }
}

