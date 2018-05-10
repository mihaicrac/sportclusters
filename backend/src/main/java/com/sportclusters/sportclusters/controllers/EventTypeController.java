package com.sportclusters.sportclusters.controllers;


import com.sportclusters.sportclusters.entity.EventType;
import com.sportclusters.sportclusters.services.eventTypeService.EventTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/event-types")
public class EventTypeController {

    @Autowired
    private EventTypeServiceImpl eventTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<EventType> getEvents() {
        return eventTypeService.findAll();
    }

}
