package com.sportclusters.sportclusters.repositories;


import com.sportclusters.sportclusters.repositories.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sportclusters.sportclusters.entity.User;

import java.util.UUID;

/**
 * Created by stephan on 20.03.16.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryCustom {
    User findByUsername(String username);
    User findByEmail(String lastname);
}
