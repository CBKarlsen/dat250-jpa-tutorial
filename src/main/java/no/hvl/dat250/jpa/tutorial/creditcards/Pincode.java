package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer count;

    public Long getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCode(String number) {
        this.code = number;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
