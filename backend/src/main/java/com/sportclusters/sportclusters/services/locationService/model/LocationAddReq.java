package com.sportclusters.sportclusters.services.locationService.model;

import javax.validation.constraints.NotNull;

public class LocationAddReq {

    @NotNull(message = "A location must have longitude")
    private Float longitude;

    @NotNull(message = "A location must have latitude")
    private Float latitude;

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
