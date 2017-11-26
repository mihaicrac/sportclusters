package com.sportclusters.sportclusters.services.eventService;

import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.entity.Location;
import com.sportclusters.sportclusters.errors.ExMsg;
import com.sportclusters.sportclusters.errors.UserNotFoundException;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import com.sportclusters.sportclusters.repositories.EventRepository;
import com.sportclusters.sportclusters.security.model.User;
import com.sportclusters.sportclusters.services.eventService.model.LocationGet;
import com.sportclusters.sportclusters.services.locationService.LocationService;
import com.sportclusters.sportclusters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@Component
public class EventService {

    @Autowired
    private EventRepository eventDb;

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;




    @Transactional
    public Event addEvent(@Valid EventAddReq req) throws UserNotFoundException {

        User owner = userService.findUser(req.getOwner());
        if(owner == null){
           throw new UserNotFoundException(ExMsg.USER_NOT_FOUND);
        }


        Event e = new Event();
        e.setOwner(owner);


        Location l = getEventLocation(req.getLocation());
        e.setLocation(l);

        return eventDb.save(e);

    }


    @Transactional
    private Location getEventLocation(@Valid LocationGet req){

        Location l = null;
        if(req.getLocation() != null) {
            l = locationService.findLocation(req.getLocation());
        }else if(req.getAddLocation() != null){
            l = locationService.addLocation(req.getAddLocation());
        }
        return l;
    }

}
