package ch.wiss.m294295.controller;


import ch.wiss.m294295.exception.CouldNotBeDeletedException.CustomerCouldNotBeDeletedException;
import ch.wiss.m294295.exception.CouldNotBeSavedException.CustomerCouldNotBeSavedException;
import ch.wiss.m294295.exception.CouldNotBeUpdatedException.CustomerCouldNotBeUpdatedException;
import ch.wiss.m294295.exception.LoadException.CustomerLoadException;
import ch.wiss.m294295.model.Customer;
import ch.wiss.m294295.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;


@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    /**
     * @param customerRepository
     * it injects the object dependency
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * With these parameters you can inject the data
     * @param name
     * @param surname
     * @param adress
     * @param email
     * @param city
     * @param postcode
     * @throws CustomerCouldNotBeSavedException if it couldn't be saved
     * @return Saved
     */
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewCustomer(String name, String surname, String adress, String email, String city, String postcode) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setAdress(adress);
        customer.setEmail(email);
        customer.setCity(city);
        customer.setPostcode(postcode);
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new CustomerCouldNotBeSavedException(customer.getName());
        }
        return ResponseEntity.ok("Saved");
    }

    /*
        @GetMapping(path = "/orders")
        public @ResponseBody List<ShopOrder> getCostumerOrders(@QueryParam("customer_id")int customer_id) {
            List<ShopOrder> shopOrders = new ArrayList<>();
            for (ShopOrder shopOrder : shopOrderRepository.findAll()){
                if (shopOrder.getCustomer_id() == customer_id){
                    shopOrders.add(shopOrder);
                }
            }
                return shopOrders;
        }

    */

    /**
     * @throws if list could not be loaded
     * @return returns a list
     */
    @GetMapping(path = "/")
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        Iterable<Customer> customer;
        try {
            customer = customerRepository.findAll();

        } catch (Exception e) {
            throw new CustomerLoadException();
        }

        return ResponseEntity.ok(customer);
    }

    /**
     * This parameter decides which record should be deleted
     * @param id
     * @throws CustomerCouldNotBeDeletedException if it couldn't be deleted
     * @return Deleted
     */
    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteCustomerById(@QueryParam("id") int id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomerCouldNotBeDeletedException();
        }
        return ResponseEntity.ok("Deleted");
    }

    /**
     * This parameter decides which record should be updated
     * @param id
     * These parameters allow you to update the data
     * @param name
     * @param surname
     * @param adress
     * @param email
     * @param city
     * @param postcode
     * @throws CustomerCouldNotBeUpdatedException if it couldn't be updated
     * @return Updated
     */
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateCustomerById(@QueryParam("id") int id,
                                                     @FormParam("name") String name,
                                                     @FormParam("surname") String surname,
                                                     @FormParam("adress") String adress,
                                                     @FormParam("email") String email,
                                                     @FormParam("city") String city,
                                                     @FormParam("postcode") String postcode) {

        Customer customer = customerRepository.findById(id);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setAdress(adress);
        customer.setEmail(email);
        customer.setCity(city);
        customer.setPostcode(postcode);
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new CustomerCouldNotBeUpdatedException(customer.getName());
        }
        return ResponseEntity.ok("Updated");
    }
}

