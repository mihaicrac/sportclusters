package com.sportclusters.sportclusters.services.userService;

import com.sportclusters.sportclusters.entity.Authority;
import com.sportclusters.sportclusters.entity.AuthorityName;
import com.sportclusters.sportclusters.repositories.AuthorityRepository;
import com.sportclusters.sportclusters.userUpdateReq;
import com.sportclusters.sportclusters.entity.User;
import com.sportclusters.sportclusters.repositories.UserRepository;
import com.sportclusters.sportclusters.security.JwtUserFactory;
import com.sportclusters.sportclusters.security.UserAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Validated
@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;


    public User findUser(UUID id){
        User ex = new User();
        ex.setId(id);
        Optional<User> user = userRepository.findOne(Example.of(ex));
        return user.orElse(null);
    }


    public User updateUser(@Valid userUpdateReq userReq){
        User ex = new User();
        ex.setId(userReq.getId());
        Optional<User> user = userRepository.findOne(Example.of(ex));
        setUpdate(userReq, user.get());
        return user.get();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User addUser(@Valid UserAddRequest userReq){
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

        User u = new User();
        u.setId(UUID.randomUUID());
        u.setFirstname(userReq.getFirstname());
        u.setLastname(userReq.getLastname());
        u.setEmail(userReq.getEmail());
        u.setPassword(encrypt.encode(userReq.getPassword()));
        u.setUsername(userReq.getUsername());

        Authority a = authorityRepository.findByName(AuthorityName.ROLE_USER);
        List<Authority> l = new ArrayList<Authority>();
        l.add(a);

        u.setAuthorities(l);
        u.setEnabled(true);
        u.setLastPasswordResetDateUTC(ZonedDateTime.now(ZoneId.of("UTC")));
        u.setLastPasswordResetDateSec(Instant.now().getEpochSecond());

        return addUserTran(u);
    }


    private User addUserTran(User u){
        System.out.println(Thread.currentThread().getName());

        if(userRepository.findByEmail(u.getEmail()) != null)
            throw new RuntimeException("Already registered email");
        try{Thread.sleep(10000);}
        catch(Exception e){
            System.out.println(Thread.currentThread());
        };
        return userRepository.save(u);
    }


    public boolean existsEmail(@NotNull String email){
        User u = userRepository.findByEmail(email);
        return u != null;
    }

    public boolean existsUsername(@NotNull String username){
        User u = userRepository.findByUsername(username);
        return u != null;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }



    private User setUpdate(userUpdateReq src, User dest){

        dest.setEmail(src.getEmail());
        dest.setFirstname(dest.getFirstname());
        dest.setLastname(dest.getLastname());

        return dest;
    }


    public void test(){
        userRepository.getCustAll();
        userRepository.findByEmail("gigel");
    }

}
