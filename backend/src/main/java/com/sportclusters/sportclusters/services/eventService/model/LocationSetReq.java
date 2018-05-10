package com.sportclusters.sportclusters.services.eventService.model;

import com.sportclusters.sportclusters.services.locationService.model.LocationAddReq;

import java.util.UUID;

public class LocationSetReq {

    private UUID location;

    LocationAddReq addLocation;

    public UUID getLocation() {
        return location;
    }

    public void setLocation(UUID location) {
        this.location = location;
    }

    public LocationAddReq getAddLocation() {
        return addLocation;
    }

    public void setAddLocation(LocationAddReq addLocation) {
        this.addLocation = addLocation;
    }
}
