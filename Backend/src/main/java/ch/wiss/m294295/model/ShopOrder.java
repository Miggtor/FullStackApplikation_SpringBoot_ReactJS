package ch.wiss.m294295.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * @Entity create the entity
 * @Table create the table
 * @GeneratedValue for the auto counted numbers
 * @ManyToOne for foreign keys
 */

@Entity
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date sqlDate;


    @Size(min = 3, max = 20, message="delivery status should be between 3 and 20 characters")
    private String deliveryStatus;

    @Size(min = 3, max = 20, message="payment status should be between 1 and 20 characters")
    private String paymentStatus;


    @OnDelete(action = OnDeleteAction.CASCADE)
    private @ManyToOne Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


/*
    public boolean removeProduct(int product_id){
        if(this.products.removeIf(product -> product.getId() == product_id)){
            return true;
        }
        return false;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
*/
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }




    public Date getSqlDate() {

        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {

        this.sqlDate = sqlDate;
    }

    public String getDeliveryStatus() {

        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {

        this.deliveryStatus = deliveryStatus;
    }

    public String getPaymentStatus() {

        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {

        this.paymentStatus = paymentStatus;
    }

}
