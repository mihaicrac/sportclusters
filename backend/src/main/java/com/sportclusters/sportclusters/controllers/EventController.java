package com.sportclusters.sportclusters.controllers;


import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.errors.EntityNotFoundException;
import com.sportclusters.sportclusters.services.eventService.EventServiceImpl;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Event addEvent(@RequestBody EventAddReq req) throws EntityNotFoundException {
        return eventService.addEvent(req);
    }

}
