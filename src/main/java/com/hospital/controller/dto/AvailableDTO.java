package com.hospital.controller.dto;

import com.hospital.controller.model.Availability;

public class AvailableDTO {

 public Long id;
 public String date;
 public Integer month;
 public Integer Year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }
    public void sync (Availability ava){
        id=ava.getAvailabilityId();
        date=ava.getDates();
        month=ava.getMonth();
        Year=ava.getYear();
    }
}
