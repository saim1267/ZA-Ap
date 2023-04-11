package com.example.myhomes;

public class Query {
    String Name;
    String Inquery;
    String phone;
    String Description;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInquery() {
        return Inquery;
    }

    public void setInquery(String inquery) {
        Inquery = inquery;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Query() {
    }

    public Query(String name, String inquery, String phone, String description) {
        Name = name;
        Inquery = inquery;
        this.phone = phone;
        Description = description;
    }
}
