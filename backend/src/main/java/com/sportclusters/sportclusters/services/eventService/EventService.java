package com.sportclusters.sportclusters.services.eventService;

import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.errors.EntityNotFoundException;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import java.util.List;

public interface EventService {

    public Event addEvent(EventAddReq req) throws EntityNotFoundException;
    public List<Event> getAll();
}
