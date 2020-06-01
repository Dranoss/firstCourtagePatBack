package com.patrimoine.website.entity;


import javax.persistence.Entity;

public class GradeStatus {


    private int id;
    private String statusName ;
    private int order ;



    public GradeStatus(int id, String statusName, int order) {
        this.id = id;
        this.statusName = statusName;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


}
