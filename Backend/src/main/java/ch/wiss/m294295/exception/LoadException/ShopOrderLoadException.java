package ch.wiss.m294295.exception.LoadException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.ShopOrder} objects could not be loaded.
 *
 * @Author Michael
 *
 */
public class ShopOrderLoadException extends RuntimeException{
    public ShopOrderLoadException(){
        super("ShopOrder could not be loaded");
    }
}
