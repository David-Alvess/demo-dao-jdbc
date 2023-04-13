package model.entities;

import java.util.Date;

public class Seller {
    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private Double salary;

    public Seller(){}

    public Seller(Integer id, String name, String email, Date birthDate, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
    }
}
