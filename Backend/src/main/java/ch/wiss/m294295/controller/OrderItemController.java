package ch.wiss.m294295.controller;

import ch.wiss.m294295.exception.CouldNotBeDeletedException.OrderItemCouldNotBeDeletedException;
import ch.wiss.m294295.exception.CouldNotBeSavedException.OrderItemCouldNotBeSavedException;
import ch.wiss.m294295.exception.CouldNotBeUpdatedException.OrderItemCouldNotBeUpdatedException;
import ch.wiss.m294295.exception.LoadException.OrderItemLoadException;
import ch.wiss.m294295.model.OrderItem;
import ch.wiss.m294295.repository.OrderItemRepository;
import ch.wiss.m294295.repository.ProductRepository;
import ch.wiss.m294295.repository.ShopOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;


@RestController
    @RequestMapping(path = "/orderitem")
    public class OrderItemController {
    /**
     * @param orderItemRepository
     * it injects the object dependency
     *
     */
        @Autowired
        private OrderItemRepository orderItemRepository;
    /**
     * @param shopOrderRepository
     * it injects the object dependency
     *
     */
        @Autowired
        private ShopOrderRepository shopOrderRepository;
    /**
     * @param ProductRepository
     * it injects the object dependency
     *
     */
        @Autowired
        private ProductRepository productRepository;

    /**
     * These parameters allow you to inject the data
     * @param quantity
     * @param shopOrder_id
     * @param product_id
     * @throws OrderItemCouldNotBeSavedException if it couldn't be saved
     * @return Saved
     */
        @PostMapping(path = "/add")
        public ResponseEntity<String> addNewOrderItem(@RequestParam int quantity, int shopOrder_id, int product_id) {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(quantity);
                orderItem.setShopOrder(shopOrderRepository.findById(shopOrder_id));
                orderItem.setProduct(productRepository.findById(product_id));
            try {
                orderItemRepository.save(orderItem);
            } catch (Exception e) {
                throw new OrderItemCouldNotBeSavedException(orderItem.getId());
            }
            return ResponseEntity.ok("Saved");
        }

    /**
     * @throws if list could not be loaded
      * @return returns a list
     */
        @GetMapping(path = "/")
        public ResponseEntity<Iterable<OrderItem>> getAllOrderItems() {
             Iterable<OrderItem> orderItem;
             try{
                 orderItem = orderItemRepository.findAll();

             } catch (Exception e){
                 throw new OrderItemLoadException();
            }
            return ResponseEntity.ok(orderItem);
        }

    /**
     * This parameter decides which record should be deleted
     * @param id
     * @throws OrderItemCouldNotBeDeletedException if it couldn't be deleted
     * @return Deleted
     */
        @DeleteMapping(path = "/delete")
        public ResponseEntity<String> deleteOrderItemById(@QueryParam("id") int id) {
            try {
                orderItemRepository.deleteById(id);
            } catch (Exception e) {
                throw new OrderItemCouldNotBeDeletedException();
            }
            return ResponseEntity.ok("Deleted");
        }

    /**
     * This parameter decides which record should be updated
     * @param id
     * These parameters allow you to update the data
     * @param shopOrder_id
     * @param product_id
     * @param quantity
     * @throws OrderItemCouldNotBeUpdatedException if it couldn't be updated
     * @return Updated
     */
        @PutMapping(path = "/update")
        public ResponseEntity<String> updateOrderItemById(@QueryParam("id") int id,
                                                            @FormParam("shopOrder_id") int shopOrder_id,
                                                            @FormParam("product_id") int product_id,
                                                            @FormParam("quantity")int quantity) {

                OrderItem orderItem = orderItemRepository.findById(id).get();
                orderItem.setQuantity(quantity);
                orderItem.setShopOrder(shopOrderRepository.findById(shopOrder_id));
                orderItem.setProduct(productRepository.findById(product_id));
            try {
                orderItemRepository.save(orderItem);
            } catch (Exception e) {
                throw new OrderItemCouldNotBeUpdatedException(orderItem.getId());
            }
            return ResponseEntity.ok("Updated");
        }
    }

