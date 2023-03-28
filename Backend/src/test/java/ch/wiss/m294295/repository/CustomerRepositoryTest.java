package ch.wiss.m294295.repository;


import ch.wiss.m294295.model.Customer;
import ch.wiss.m294295.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

/**
 * These Functions get tested
 */


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
class CustomerControllerTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
        // JUnit test for addNewCustomer
    void addNewCustomerTest(){
        Customer customer = new Customer();
        customer.setName("Conner");
        customer.setSurname("Klee");
        customer.setAdress("Gommisstrasse 1");
        customer.setCity("Gommisberg");
        customer.setEmail("gommis@gmail.com");
        customer.setPostcode("9020");

        customerRepository.save(customer);

        Assertions.assertThat(customer.getId()).isGreaterThan(0);


    }

    @Test
    @Order(3)
        // JUnit test for getAllCustomers
    void getAllCustomersTest(){
        List<Customer> customers = (List<Customer>) customerRepository.findAll();


        Assertions.assertThat(customers.size()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    void getCustomerById(){
        Customer customer = customerRepository.findById(1);

        Assertions.assertThat(customer.getId()).isEqualTo(1);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
        // JUnit test for UpdateCustomerById
    void updateCustomerByIdTest(){

        Customer customer = customerRepository.findById(1);

        customer.setSurname("Weberino");

        Customer customerUpdated = customerRepository.save(customer);
        Assertions.assertThat(customerUpdated.getSurname()).isEqualTo("Weberino");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
        // JUnit test for deleteCustomerById

    void deleteCustomerByIdTest(){
        Customer customer = customerRepository.findById(1);

        customerRepository.delete(customer);

        Customer customer1 = null;

        Optional<Customer> optionalCustomers = Optional.ofNullable(customerRepository.findBySurname("Weberino"));

        if(optionalCustomers.isPresent()){
            customer1 = optionalCustomers.get();
        }

        Assertions.assertThat(customer1).isNull();
    }
}
