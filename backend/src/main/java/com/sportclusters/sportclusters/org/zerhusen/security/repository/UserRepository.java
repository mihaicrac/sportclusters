package com.sportclusters.sportclusters.org.zerhusen.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sportclusters.sportclusters.org.zerhusen.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
