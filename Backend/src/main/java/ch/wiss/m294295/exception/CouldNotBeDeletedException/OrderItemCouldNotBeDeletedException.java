package ch.wiss.m294295.exception.CouldNotBeDeletedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.OrderItem} objects could not be deleted.
 *
 * @Author Michael
 *
 */
public class OrderItemCouldNotBeDeletedException extends RuntimeException{
    public OrderItemCouldNotBeDeletedException(){
        super("The OrderItem could not be deleted");
    }

}
