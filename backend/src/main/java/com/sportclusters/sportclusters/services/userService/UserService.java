package com.sportclusters.sportclusters.services.userService;

import com.sportclusters.sportclusters.entity.User;
import com.sportclusters.sportclusters.security.UserAddRequest;
import com.sportclusters.sportclusters.userUpdateReq;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface UserService {

    User findUser(UUID id);
    User updateUser(@Valid userUpdateReq userReq);
    User addUser(@Valid UserAddRequest userReq);
    boolean existsEmail(@NotNull String email);
    boolean existsUsername(@NotNull String username);
}
