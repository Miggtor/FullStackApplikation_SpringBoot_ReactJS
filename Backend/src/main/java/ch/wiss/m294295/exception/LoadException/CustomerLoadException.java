package ch.wiss.m294295.exception.LoadException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Customer} objects could not be loaded.
 *
 * @Author Michael
 *
 */
public class CustomerLoadException extends RuntimeException{
    public CustomerLoadException(){
        super("Customer could not be loaded.");
    }
}
