package ch.wiss.m294295.repository;


import ch.wiss.m294295.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for create, read, update, delete
 */
@Repository
public interface CustomerRepository extends CrudRepository <Customer, Integer> {
    Customer findById(int id);
    Customer deleteById(int id);
    Customer findBySurname(String surname);
}
