package com.patrimoine.website.entity;

import java.sql.Date;
import java.util.List;



public class Project {


    private int id;
    private int amount;
    private Date openDate;
    private Date closeDate;

    private TypeProject typeProject;
    private List<Document> documents;
    private GradeStatus status ;


    public Project(int id, int amount, Date openDate, Date closeDate) {
        this.id = id;
        this.amount = amount;

        if (openDate == null){
            System.out.println("creation de projet sans date d ouverture !");

        }else{
            this.openDate = openDate;
        }

        this.closeDate = closeDate;
    }

    public int getId() {
        return id;
    }

    /* id auto incrementé
    public void setId(int id) {
        this.id = id;
    }
    */
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
}
