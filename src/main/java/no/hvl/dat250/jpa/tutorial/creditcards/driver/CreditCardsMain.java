package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;


public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {

    //Lager bank
    Bank bank = new Bank();
    bank.setName("Pengebank");

    //Setter pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    //Lager kredittkort1
    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    card1.setOwningBank(bank);
    card1.setPincode(pincode);

    //lager kredittkort2
    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setOwningBank(bank);
    card2.setPincode(pincode);


    //Kunde max blir laget
    Customer max = new Customer();
    max.setName("Max Mustermann");
    max.addCreditCard(card1);
    max.addCreditCard(card2);

    //Adresse til max
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    address.addOwner(max);

    //Lagrer objektene
    em.persist(bank);
    em.persist(pincode);
    em.persist(card1);
    em.persist(card2);
    em.persist(max);
    em.persist(address);

  }
}
