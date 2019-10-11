package com.hospital.controller.dto;

import java.util.Date;

public class AvailableDTO {

 public Long id;
 public Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
