package com.sportclusters.sportclusters.services.eventTypeService;

import com.sportclusters.sportclusters.entity.EventType;
import com.sportclusters.sportclusters.repositories.EventRepository;
import com.sportclusters.sportclusters.repositories.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventTypeServiceImpl implements EventTypeService{

    @Autowired
    EventTypeRepository eventTypeRepository;

    public List<EventType> findAll(){
        return eventTypeRepository.findAll();
    }
    public EventType findById(UUID id){
        return eventTypeRepository.findById(id).get();
    }

}
