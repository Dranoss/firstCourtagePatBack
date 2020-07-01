package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class UserRib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String ownerName;
    private String ibanNumber;
    private String bicCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "userRib")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserRib() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }
}
