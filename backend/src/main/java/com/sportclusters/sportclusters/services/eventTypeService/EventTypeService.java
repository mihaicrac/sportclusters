package com.sportclusters.sportclusters.services.eventTypeService;

import com.sportclusters.sportclusters.entity.EventType;

import java.util.List;
import java.util.UUID;

public interface EventTypeService {

    public List<EventType> findAll();
    public EventType findById(UUID id);
}
