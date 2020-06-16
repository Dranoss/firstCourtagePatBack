package com.patrimoine.website.webServices.entity;

import javax.persistence.*;

@Entity
public class UserRib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rib_id")
    private Long id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "iban_number")
    private String ibanNumber;
    @Column(name = "bic_code")
    private String bicCode;

    public UserRib() {
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
