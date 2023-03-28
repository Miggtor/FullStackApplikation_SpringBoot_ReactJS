package ch.wiss.m294295.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * @Entity create the entity
 * @Table create the table
 * @GeneratedValue for the auto counted numbers
 * @Size to validate Strings
 */

@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String name;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String surname;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String adress;
    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String email;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String city;

    @Size(min = 3, max = 50, message="name should be between 3 and 50 characters")
    private String postcode;

    public Customer(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(adress, customer.adress) && Objects.equals(email, customer.email) && Objects.equals(city, customer.city) && Objects.equals(postcode, customer.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, adress, email, city, postcode);
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

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getAdress() {

        return adress;
    }

    public void setAdress(String adress) {

        this.adress = adress;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getPostcode() {

        return postcode;
    }

    public void setPostcode(String postcode) {

            this.postcode = postcode;
    }
}
