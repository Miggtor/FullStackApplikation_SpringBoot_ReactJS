package ch.wiss.m294295.repository;


import ch.wiss.m294295.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for create, read, update, delete
 */
public interface OrderItemRepository extends CrudRepository <OrderItem, Integer> {
}
