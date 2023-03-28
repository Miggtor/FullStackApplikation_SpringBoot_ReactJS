package ch.wiss.m294295.exception.LoadException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.OrderItem} objects could not be loaded.
 *
 * @Author Michael
 *
 */
public class OrderItemLoadException extends RuntimeException{
    public OrderItemLoadException(){
        super("OrderItem could not be loaded");
    }
}
