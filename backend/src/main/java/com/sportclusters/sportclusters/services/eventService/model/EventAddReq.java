package com.sportclusters.sportclusters.services.eventService.model;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class EventAddReq {

    private LocationGet location;

    @NotNull(message = "An event must have a StartDate")
    private Date date;


    @NotNull(message = "An event must have an owner")
    private UUID owner;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public LocationGet getLocation() {
        return location;
    }

    public void setLocation(LocationGet location) {
        this.location = location;
    }
}
