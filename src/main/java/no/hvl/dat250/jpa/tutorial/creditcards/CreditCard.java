package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer limit;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private Pincode pincode;

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        // TODO: implement method!
        return balance;
    }

    public Integer getCreditLimit() {
        // TODO: implement method!
        return limit;
    }

    public Pincode getPincode() {
        return pincode;
    }
    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return bank;
    }

    public void setOwningBank(Bank bank) {
        this.bank = bank;
        bank.getOwnedCards().add(this);
    }

    public void setCreditLimit(int limit) {
        this.limit = limit;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
