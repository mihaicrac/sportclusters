package com.sportclusters.sportclusters.services.locationService;

import com.sportclusters.sportclusters.entity.Location;
import com.sportclusters.sportclusters.services.locationService.model.LocationAddReq;

import java.util.UUID;

public interface LocationService {

    public Location addLocation(LocationAddReq location);
    public Location getLocation(UUID id);
}
