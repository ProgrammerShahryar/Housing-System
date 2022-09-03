package com.example.assignment.model;

public class Application {
    public int id;
    public String date;
    public String month;
    public String year;
    public String status;
    public int resid;
    public String fromdate;
    public String duration;


    public Application(){

    }

    public Application(int id, String date, String month, String year, String status, int resid, String fromdate, String duration) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
        this.status = status;
        this.resid = resid;
        this.fromdate = fromdate;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Application {" +
                "Id = '" + id + '\'' + " " +
                ",  Date = '" + date + '\'' + " " +
                ",  Month = '" + month + '\'' + " " +
                ",  Year = '" + year + '\'' + " " +
                ",  Status = '" + status + '\'' + " " +
                ",  Residence ID = " + resid + " " +
                '}';
    }
}
