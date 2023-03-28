package ch.wiss.m294295.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DecimalMin(value = "1.0", inclusive = false, message = "eanCode should be between 1 and 200")
    @DecimalMax(value = "200.0", inclusive = false, message = "eanCode should be between 1 and 200")
    private int eancode;
    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String name;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String category;

    @DecimalMin(value = "0.0", inclusive = false, message = "price should be between 0.1 and 10000")
    @DecimalMax(value = "10000.0", inclusive = false, message = "price should be between 0.1 and 10000")
    private BigDecimal price;




    public int getEancode() {
        return eancode;
    }

    public void setEancode(int eanCode) {
        this.eancode = eanCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null) {
            this.category = category;
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice (BigDecimal price) {
            this.price = price;
        }
    }

