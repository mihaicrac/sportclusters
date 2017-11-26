package com.sportclusters.sportclusters.services.locationService;

import com.sportclusters.sportclusters.entity.Location;
import com.sportclusters.sportclusters.services.locationService.model.LocationAddReq;
import com.sportclusters.sportclusters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.UUID;

@Validated
@Component
public class LocationService {

    @Autowired
    LocationRepository locationDb;


    @Transactional
    public Location addLocation(LocationAddReq location){

        Location l = new Location();

        l.setLatitude(location.getLatitude());
        l.setLongitude(location.getLongitude());

        return locationDb.save(l);
    }


    @Transactional
    public Location findLocation(UUID id){

        return locationDb.findOne(id);
    }

}
