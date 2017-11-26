package com.sportclusters.sportclusters.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sportclusters.sportclusters.security.model.User;

import java.util.UUID;

/**
 * Created by stephan on 20.03.16.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
