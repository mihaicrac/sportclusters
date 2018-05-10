package com.sportclusters.sportclusters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sportclusters.sportclusters.entity.Authority;
import com.sportclusters.sportclusters.entity.AuthorityName;

@RepositoryRestResource(exported = false)
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
