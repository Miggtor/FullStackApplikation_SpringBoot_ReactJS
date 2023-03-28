package ch.wiss.m294295.repository;


import ch.wiss.m294295.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for create, read, update, delete
 */
public interface ProductRepository  extends CrudRepository <Product, Integer> {
    Product findById(int id);
    Product findByEancode(int eancode);
}
