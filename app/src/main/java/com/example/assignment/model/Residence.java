package com.example.assignment.model;

public class Residence {
    private int residenceid;
    private String address ;
    private String numOfUnit;
    private String sizePerUnit;
    private String monthlyRental;
    private String status;

    public Residence(int residenceid, String address, String numOfUnit, String sizePerUnit, String monthlyRental, String status) {
        this.residenceid = residenceid;
        this.address = address;
        this.numOfUnit = numOfUnit;
        this.sizePerUnit = sizePerUnit;
        this.monthlyRental = monthlyRental;
        this.status = status;
    }

    public Residence() {

    }

    public int getResidenceid() {
        return residenceid;
    }

    public void setResidenceid(int residenceid) {
        this.residenceid = residenceid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumOfUnit() {
        return numOfUnit;
    }

    public void setNumOfUnit(String numOfUnit) {
        this.numOfUnit = numOfUnit;
    }

    public String getSizePerUnit() {
        return sizePerUnit;
    }

    public void setSizePerUnit(String sizePerUnit) {
        this.sizePerUnit = sizePerUnit;
    }

    public String getMonthlyRental() {
        return monthlyRental;
    }

    public void setMonthlyRental(String monthlyRental) {
        this.monthlyRental = monthlyRental;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Residence {" +
                "Id = " + residenceid + '\'' + " " +
                ",  Address = '" + address + '\'' + " " +
                ",  NumOfUnit = '" + numOfUnit + '\'' + " " +
                ",  SizePerUnit = '" + sizePerUnit + '\'' + " " +
                ",  MonthlyRental = '" + monthlyRental + '\'' + " " +
                ",  Availability = '" + status + '\'' + " " +
                '}';
    }

}

