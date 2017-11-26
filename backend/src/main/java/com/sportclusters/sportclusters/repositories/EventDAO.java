package com.sportclusters.sportclusters.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class EventDAO {
    @Autowired
    EntityManager em;


    public void addEvent(){
    //    em.persist();

    }

}
