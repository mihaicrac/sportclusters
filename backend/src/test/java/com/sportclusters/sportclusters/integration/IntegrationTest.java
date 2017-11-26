package com.sportclusters.sportclusters.integration;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ActiveProfiles("qa")
@Transactional
@Ignore
public class IntegrationTest {
    @Autowired
    ApplicationContext context;

    public void contextTest(){
        System.out.println("asdasds");
    }
}
