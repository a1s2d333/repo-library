package com.demo.mylibrary;

import com.google.gson.annotations.SerializedName;

public class Person{
    @SerializedName("name")

    private String name;
    @SerializedName("age")
    private int age;
    @SerializedName("gender")
    private String gender;
    @SerializedName("dt")
    private Doctor dt;
    public Person(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Doctor getDt() {
        return dt;
    }

    public void setDt(Doctor dt) {
        this.dt = dt;
    }

    public void setWorks(Doctor dt){
        this.dt=dt;
    }
}

class Doctor{
    private String workName;
    private int age;
}
