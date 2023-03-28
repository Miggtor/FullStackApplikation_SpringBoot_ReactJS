package ch.wiss.m294295.exception.CouldNotBeSavedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.ShopOrder} objects could not be saved.
 *
 * @Author Michael
 *
 */
public class ShopOrderCouldNotBeSavedException extends RuntimeException{
    public ShopOrderCouldNotBeSavedException(int ShopOrderId){
        super("The ShopOrder with the Id"+ ShopOrderId +"could not be saved");
    }
}