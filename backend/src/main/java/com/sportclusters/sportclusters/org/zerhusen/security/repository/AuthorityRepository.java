package com.sportclusters.sportclusters.org.zerhusen.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sportclusters.sportclusters.org.zerhusen.model.security.Authority;
import com.sportclusters.sportclusters.org.zerhusen.model.security.AuthorityName;

@RepositoryRestResource(exported = false)
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
