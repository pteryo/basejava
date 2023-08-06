package com.learnjava.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Period implements Serializable {
    public LocalDate startDate;
    public LocalDate endDate;

    public String title;
    public String description;
    public Period(LocalDate startDate,LocalDate endDate,String title,String description){
        this.startDate   = startDate   ;
        this.endDate     = endDate     ;
        this.title       = title       ;
        this.description = description ;
    }
}
