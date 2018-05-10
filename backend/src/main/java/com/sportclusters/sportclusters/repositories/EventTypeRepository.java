package com.sportclusters.sportclusters.repositories;

import com.sportclusters.sportclusters.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventTypeRepository extends JpaRepository<EventType, UUID> {
    EventType findByName(String name);
}
