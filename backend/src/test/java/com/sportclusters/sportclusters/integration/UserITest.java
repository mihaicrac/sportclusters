package com.sportclusters.sportclusters.integration;

import com.sportclusters.sportclusters.SportclustersApplication;
import com.sportclusters.sportclusters.security.UserAddRequest;
import com.sportclusters.sportclusters.services.userService.UserService;
import com.sportclusters.sportclusters.services.userService.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ActiveProfiles("qa")
@SpringBootTest(classes = SportclustersApplication.class)
public class UserITest {

    @Autowired
    ApplicationContext context;

    @Autowired
    UserService userService;

    public void contextTest(){
        System.out.println("asdasds");
    }

    @Test
    @Transactional
    @Rollback
    public void userPostTest(){
        UserAddRequest req = new UserAddRequest();
        req.setEmail("asdsa@email.com");
        req.setFirstname("firstname1");
        req.setLastname("lastname1");
        req.setPassword("passw1");
        req.setUsername("username1");

        Thread t1 = new Thread(()->{
            userService.addUser(req);
        });
        Thread t2 = new Thread(()->{
            userService.addUser(req);
        });
        t1.setName("------------t1---------");
        t2.setName("------------t2---------");

        t1.start();
        t2.start();

    //    userService.addUser(req);
    //    userService.findUser(u.getId());
    //    userService.test();

    }

/*    private Runnable getSave(UserAddRequest req){

    }
*/
}
