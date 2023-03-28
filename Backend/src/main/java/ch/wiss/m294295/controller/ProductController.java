package ch.wiss.m294295.controller;

import ch.wiss.m294295.exception.CouldNotBeDeletedException.ProductCouldNotBeDeletedException;
import ch.wiss.m294295.exception.CouldNotBeSavedException.ProductCouldNotBeSavedException;
import ch.wiss.m294295.exception.CouldNotBeUpdatedException.ProductCouldNotBeUpdatedException;
import ch.wiss.m294295.exception.LoadException.ProductLoadException;
import ch.wiss.m294295.model.Product;
import ch.wiss.m294295.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    /**
     * @param productRepository
     * it injects the object dependency
     *
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * These parameters allow you to inject the data
     * @param name
     * @param eancode
     * @param category
     * @param price
     * @throws ProductCouldNotBeSavedException if it couldn't be saved
     * @return Saved
     */
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewProduct(@RequestParam String name, int eancode, String category, BigDecimal price) {
            Product product = new Product();
            product.setName(name);
            product.setEancode(eancode);
            product.setCategory(category);
            product.setPrice(price);
        try {
            productRepository.save(product);

        } catch (Exception e) {
           throw new ProductCouldNotBeSavedException(product.getName());
        }
        return ResponseEntity.ok("Saved");
    }

    /**
     * @throws if list could not be loaded
     * @return returns a list
     */
    @GetMapping(path = "/")
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> product;
        try{
            product =  productRepository.findAll();
        }catch (Exception e){
            throw new ProductLoadException();
        }
        return ResponseEntity.ok(product);
    }

    /**
     * This parameter decides which record should be deleted
     * @param id
     * @throws ProductCouldNotBeDeletedException if it couldn't be deleted
     * @return Deleted
     */
    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteProductById(@QueryParam("id") int id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new ProductCouldNotBeDeletedException();
        }
        return ResponseEntity.ok("Deleted");
    }

    /**
     * This parameter decides which record should be updated
     * @param id
     * These parameters allow you to update the data
     * @param eancode
     * @param name
     * @param category
     * @param price
     * @throws ProductCouldNotBeUpdatedException if it couldn't be updated
     * @return Updated
     */
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateProductById(@QueryParam("id") int id,
                                                  @FormParam("eancode") int eancode,
                                                  @FormParam("name") String name,
                                                  @FormParam("category") String category,
                                                  @FormParam("price") BigDecimal price) {

            Product product = productRepository.findById(id);
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setEancode(eancode);
        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new ProductCouldNotBeUpdatedException(product.getName());
        }
        return ResponseEntity.ok("Updated");
    }
}
