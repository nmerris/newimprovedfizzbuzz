package com.nmerris.newimprovedfb.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @NotEmpty
    private String name;

    private String userMessage;

    // date is not something the user can enter, it is timestamped
    private Date startDate;

    @NotNull
//    @Size(min = 10, max = 1000)
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
