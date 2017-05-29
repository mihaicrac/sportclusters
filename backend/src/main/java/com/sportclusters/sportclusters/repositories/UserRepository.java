package com.sportclusters.sportclusters.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.sportclusters.sportclusters.entity.User;

public interface UserRepository extends CrudRepository<User, UUID>{

}
