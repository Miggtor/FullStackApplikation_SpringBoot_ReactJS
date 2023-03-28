package ch.wiss.m294295.exception.CouldNotBeSavedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.OrderItem} objects could not be saved.
 *
 * @Author Michael
 *
 */
public class OrderItemCouldNotBeSavedException extends RuntimeException{
    public OrderItemCouldNotBeSavedException(int OrderItemId){
        super("The OrderItem with the name"+ OrderItemId+"could not be saved");
    }

}
