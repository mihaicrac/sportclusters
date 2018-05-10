package com.sportclusters.sportclusters.services.locationService;

import com.sportclusters.sportclusters.entity.Location;
import com.sportclusters.sportclusters.services.locationService.model.LocationAddReq;
import com.sportclusters.sportclusters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.UUID;

@Validated
@Service
public class LocationServiceImpl implements LocationService{

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
    public Location getLocation(UUID id){
        Location l = new Location();
        l.setId(id);
        Example<Location> ex = Example.of(l);
        return locationDb.findOne(ex).get();
    }

}
