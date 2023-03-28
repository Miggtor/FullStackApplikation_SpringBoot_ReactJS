package ch.wiss.m294295.exception.CouldNotBeDeletedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Customer} objects could not be deleted.
 *
 * @Author Michael
 *
 */
public class CustomerCouldNotBeDeletedException extends RuntimeException{
    public CustomerCouldNotBeDeletedException(){
        super("The Customer could not be deleted");
    }
}
