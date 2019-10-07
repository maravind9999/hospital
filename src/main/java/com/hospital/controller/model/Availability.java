package com.hospital.controller.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
public class Availability {

    @Id
    @GeneratedValue
    @Column(name = "availability_Id")
    private Long availabilityId;

    @Column(name = "time_From")
    private Time  timeFrom;

    @Column(name = "time_To")
    private Time timeTo;

    @OneToMany(targetEntity = Contact.class, mappedBy = "availability", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Availability> availabilities;

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }
}
