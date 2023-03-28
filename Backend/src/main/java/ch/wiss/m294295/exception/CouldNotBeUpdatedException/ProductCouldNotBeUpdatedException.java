package ch.wiss.m294295.exception.CouldNotBeUpdatedException;

/**
 * This Exception is thrown when a list of {@link ch.wiss.m294295.model.Product} objects could not be updated.
 *
 * @Author Michael
 *
 */
public class ProductCouldNotBeUpdatedException extends RuntimeException{
public ProductCouldNotBeUpdatedException(String ProductName){
    super("The ShopOrder with the Id"+ ProductName +"could not be saved");
}
}
