package ch.wiss.m294295.exception.CouldNotBeUpdatedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Customer} objects could not be updated.
 *
 * @Author Michael
 *
 */
public class CustomerCouldNotBeUpdatedException extends RuntimeException{
public CustomerCouldNotBeUpdatedException(String CustomerName){
    super("The Customer with the name"+CustomerName+"could not be updated");
}
}
