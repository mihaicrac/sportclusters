package com.sportclusters.sportclusters.services.eventService.model;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class EventAddReq {

    @NotNull(message = "An event must have a location")
    private LocationSetReq location;

    @NotNull(message = "An event must have a StartDate")
    private Long date;

    @NotNull(message = "An event must have an owner")
    private UUID owner;

    private Integer duration;

    private Integer maxPlayers;

    private Integer ownerGuests;

    private UUID eventType;


    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public LocationSetReq getLocation() {
        return location;
    }

    public void setLocation(LocationSetReq location) {
        this.location = location;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getOwnerGuests() {
        return ownerGuests;
    }

    public void setOwnerGuests(Integer ownerGuests) {
        this.ownerGuests = ownerGuests;
    }

    public UUID getEventType() {
        return eventType;
    }

    public void setEventType(UUID eventType) {
        this.eventType = eventType;
    }
}
