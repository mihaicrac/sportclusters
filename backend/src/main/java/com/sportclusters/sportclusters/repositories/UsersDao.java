package com.sportclusters.sportclusters.repositories;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sportclusters.sportclusters.entity.User;

//@Transactional
//@Repository
public class UsersDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public void update(User user) {
		entityManager.merge(user);
	}

	public User getUserById(UUID id) {
		return entityManager.find(User.class, id);
	}
	
	public User getUserByName(String firstName) {
		return entityManager.find(User.class, firstName);
	}
	
	public void delete(UUID id) {
		User user = getUserById(id);
		if (user != null) {
			entityManager.remove(user);
		}
	}
}	