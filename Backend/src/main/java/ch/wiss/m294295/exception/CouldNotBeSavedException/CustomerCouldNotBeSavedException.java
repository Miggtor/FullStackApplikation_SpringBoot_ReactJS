package ch.wiss.m294295.exception.CouldNotBeSavedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Customer} objects could not be saved.
 *
 * @Author Michael
 *
 */
public class CustomerCouldNotBeSavedException extends RuntimeException{
    public CustomerCouldNotBeSavedException(String CustomerName){
        super("The Customer with the name"+ CustomerName+"could not be saved");
    }
}
