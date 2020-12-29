package com.example.testapi;

public class Employees {
    private String id;
    private String name;
    private String position;

    public Employees(){}
    public Employees(String id,String name,String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "Employee:"+ id +"   姓名："+ name +"职位："+ position;
    }
}
