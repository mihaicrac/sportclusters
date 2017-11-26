package com.sportclusters.sportclusters.repositories;

import com.sportclusters.sportclusters.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
