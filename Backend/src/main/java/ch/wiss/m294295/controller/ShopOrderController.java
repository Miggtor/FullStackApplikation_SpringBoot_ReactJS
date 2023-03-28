package ch.wiss.m294295.controller;

import ch.wiss.m294295.exception.CouldNotBeDeletedException.ShopOrderCouldNotBeDeletedException;
import ch.wiss.m294295.exception.CouldNotBeSavedException.ShopOrderCouldNotBeSavedException;
import ch.wiss.m294295.exception.CouldNotBeUpdatedException.ShopOrderCouldNotBeUpdatedException;
import ch.wiss.m294295.exception.LoadException.ShopOrderLoadException;
import ch.wiss.m294295.model.ShopOrder;
import ch.wiss.m294295.repository.CustomerRepository;
import ch.wiss.m294295.repository.ShopOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

@RestController
@RequestMapping(path = "/order")
public class ShopOrderController {
    /**
     * @param customerRepository
     * it injects the object dependency
     *
     */
    @Autowired
    private CustomerRepository customerRepository;
    /**
     * @param shopOrderRepository
     * it injects the object dependency
     *
     */
    @Autowired
    private ShopOrderRepository shopOrderRepository;

    /**
     * These parameters allow you to inject the data
     * @param date
     * @param deliveryStatus
     * @param paymentStatus
     * @param customer_id
     * @throws ShopOrderCouldNotBeSavedException if it couldn't be saved
     * @return Saved
     */
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewShopOrder(java.sql.Date date, String deliveryStatus, String paymentStatus, int customer_id) {
        ShopOrder shopOrder = new ShopOrder();
            shopOrder.setSqlDate(date);
            shopOrder.setDeliveryStatus(deliveryStatus);
            shopOrder.setPaymentStatus(paymentStatus);
            shopOrder.setCustomer(customerRepository.findById(customer_id));
        try {
            shopOrderRepository.save(shopOrder);

        } catch (Exception e) {
            throw new ShopOrderCouldNotBeSavedException(shopOrder.getId());
        }
        return ResponseEntity.ok("Saved");
    }
/*
    @PostMapping(path = "/addProduct")
    public @ResponseBody String addShopOrderProduct(@QueryParam("shopOrder_id")int shopOrder_id, @QueryParam("product_id") int product_id) {
        try {
            Product product = productRepository.findById(product_id).get();
            shopOrderRepository.findById(shopOrder_id).get().addProduct(product);
            return "product adding successful";
        } catch (Exception e) {

            return "product adding Failed";
        }
    }
    @GetMapping(path = "/getProducts")
    public @ResponseBody List<Product> getShopOrderProducts(@QueryParam("shopOrder_id") int shopOrder_id) {
       return shopOrderRepository.findById(shopOrder_id).get().getProducts();
        }

*/

    /**
     * @throws if list could not be loaded
     * @return returns a list
     */
    @GetMapping(path = "/")
    public ResponseEntity<Iterable<ShopOrder>> getAllShopOrders() {
        Iterable<ShopOrder> shopOrder;
        try{
            shopOrder = shopOrderRepository.findAll();
        }catch (Exception e){
            throw new ShopOrderLoadException();
        }
        return ResponseEntity.ok(shopOrder);
    }

    /**
     * This parameter decides which record should be deleted
     * @param id
     * @throws ShopOrderCouldNotBeDeletedException if it couldn't be deleted
     * @return Deleted
     */

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteShopOrderById(@QueryParam("id") int id) {
        try {
            shopOrderRepository.deleteById(id);
        } catch (Exception e) {
            throw new ShopOrderCouldNotBeDeletedException();
        }
        return ResponseEntity.ok("Deleted");
    }

    /**
     *This parameter decides which record should be updated
     * @param id
     * These parameters allow you to update the data
     * @param date
     * @param deliveryStatus
     * @param paymentStatus
     * @param customer_id
     * @throws ShopOrderCouldNotBeUpdatedException if it couldn't be updated
     * @return Updated
     */
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateShopOrderById(@QueryParam("id") int id,
                                                  @FormParam("date") java.sql.Date date,
                                                  @FormParam("deliveryStatus") String deliveryStatus,
                                                  @FormParam("paymentStatus") String paymentStatus,
                                                  @FormParam("customer_id")int customer_id) {

            ShopOrder shoporder = shopOrderRepository.findById(id);
            shoporder.setSqlDate(date);
            shoporder.setDeliveryStatus(deliveryStatus);
            shoporder.setPaymentStatus(paymentStatus);
            shoporder.setCustomer(customerRepository.findById(customer_id));
        try{
            shopOrderRepository.save(shoporder);
        } catch (Exception e) {
            throw new ShopOrderCouldNotBeUpdatedException(shoporder.getId());

        }
        return ResponseEntity.ok("Updated");
    }

}
