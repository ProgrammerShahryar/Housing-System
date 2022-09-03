package com.example.assignment.model;

public class User {
    public String id;
    public String userName;
    public String password;
    public String fullName;
    public String email;
    public String monthlyIncome;

    public User(String id, String UserName,String Password)
    {
        this.id=id;
        this.userName=UserName;
        this.password=Password;
    }
    //Parameter constructor containing all three parameters
    public User(String id,String UserName,String Password, String FullName, String Email, String MonthIncome)
    {
        this.id=id;
        this.userName=UserName;
        this.password=Password;
        this.fullName=FullName;
        this.email=Email;
        this.monthlyIncome=MonthIncome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}
