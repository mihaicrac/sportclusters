package com.sportclusters.sportclusters.services.eventService;

import com.sportclusters.sportclusters.entity.*;
import com.sportclusters.sportclusters.errors.ExMsg;
import com.sportclusters.sportclusters.errors.EntityNotFoundException;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import com.sportclusters.sportclusters.repositories.EventRepository;
import com.sportclusters.sportclusters.services.eventTypeService.EventTypeServiceImpl;
import com.sportclusters.sportclusters.services.locationService.LocationServiceImpl;
import com.sportclusters.sportclusters.services.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Validated
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventDb;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LocationServiceImpl locationService;

    @Autowired
    private EventTypeServiceImpl eventTypeService;


    @Transactional
    public Event addEvent(@Valid EventAddReq req) throws EntityNotFoundException {

        User owner = userService.findUser(req.getOwner());
        if(owner == null){
           throw new EntityNotFoundException(ExMsg.USER_NOT_FOUND);
        }

        Event e = new Event();
        e.setOwner(owner);

        Location l = null;
        if(req.getLocation().getLocation() != null) {
            l = locationService.getLocation(req.getLocation().getLocation());
        }else if(req.getLocation().getAddLocation() != null){
            l = locationService.addLocation(req.getLocation().getAddLocation());
        }
        e.setLocation(l);

        e.setDate(new Date(req.getDate() * 1000));

        EventType type = null;
        if(req.getEventType() != null){
            type = eventTypeService.findById(req.getEventType());
        }
        e.setEventType(type);

        e.setMaxPlayersNumber(req.getMaxPlayers());
        e.addUser(owner, req.getOwnerGuests());

        e = eventDb.save(e);

        return e;
    }

    public List<Event> getAll(){
        return eventDb.findAll();
    }

}
