package com.nmerris.newimprovedfb.models;

import java.util.Date;

public class User {

    private String name;
    private String userMessage;
    private Date startDate;
    private long numPicked;


    public long getNumPicked() {
        return numPicked;
    }

    public void setNumPicked(long numPicked) {
        this.numPicked = numPicked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }



}
