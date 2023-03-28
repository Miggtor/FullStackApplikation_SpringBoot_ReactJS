package ch.wiss.m294295.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * @Entity create the entity
 * @Table create the table
 * @GeneratedValue for the auto counted numbers
 * @Range to validate int
 * @ManyToOne for foreign keys
 */
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Range(min = 1, max = 100, message = "quantity should be between 1 and 100")
    private int quantity;


    @OnDelete(action = OnDeleteAction.CASCADE)
    private @ManyToOne ShopOrder shopOrder;

    @OnDelete(action = OnDeleteAction.CASCADE)
    private @ManyToOne Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
