package com.sportclusters.sportclusters.repositories.custom.impl;

import com.sportclusters.sportclusters.entity.User;
import com.sportclusters.sportclusters.repositories.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<User> getCustAll(){
        TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User u", User.class);
        return q.getResultList();
    }


}
