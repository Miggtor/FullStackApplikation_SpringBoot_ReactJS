package ch.wiss.m294295.repository;


import ch.wiss.m294295.model.ShopOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for create, read, update, delete
 */
public interface ShopOrderRepository extends CrudRepository <ShopOrder, Integer> {

    ShopOrder findById(int id);
}
