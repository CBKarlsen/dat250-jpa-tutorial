package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany
    private Set<Customer> owners = new HashSet<>();

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Collection<Customer> getOwners() {
        return owners;
    }

    public void addOwner(Customer customer) {
        owners.add(customer);
        customer.getAddresses().add(this);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
