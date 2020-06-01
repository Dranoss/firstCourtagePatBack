package com.patrimoine.website.entity;


public class TypeProject extends Type {




    private int id;
    private String name = "";

    public TypeProject(int id, String name, int id1, String name1) {
        super(id, name);
        this.id = id1;
        this.name = name1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
