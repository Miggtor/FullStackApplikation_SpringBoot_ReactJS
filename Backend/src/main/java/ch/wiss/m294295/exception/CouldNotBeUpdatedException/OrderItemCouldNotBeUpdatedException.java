package ch.wiss.m294295.exception.CouldNotBeUpdatedException;

import ch.wiss.m294295.model.OrderItem;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.OrderItem} objects could not be updated.
 *
 * @Author Michael
 *
 */
public class OrderItemCouldNotBeUpdatedException extends RuntimeException{
    public OrderItemCouldNotBeUpdatedException(int OrderItemId){
        super("The OrderItem with the Id"+OrderItemId+"could not be updated");
    }
}
