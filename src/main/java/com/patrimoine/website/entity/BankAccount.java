package com.patrimoine.website.entity;


public class BankAccount {



    private int id;
    private String iban ;
    private String bic ;
    private String ownerFullName;
    private String bankName;

    public BankAccount(int id, String test){
        this.id = id;
        this.bankName = test;


    }

    public BankAccount(int id, String iban, String bic, String ownerFullName, String bankName) {
        this.id = id;
        this.iban = iban;
        this.bic = bic;
        this.ownerFullName = ownerFullName;
        this.bankName = bankName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
