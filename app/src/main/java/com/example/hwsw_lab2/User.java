package com.example.hwsw_lab2;

public class User {

    public String fullName, email;
    private String dateOfSleep;
    private int duration;
    private String level;
    private int seconds;


    public User(String name, String email){

    }

    public User(String fullName, String age, String email){
        this.fullName = fullName;
        this.email = email;
    }



}
