package com.sportclusters.sportclusters.unit.services;

import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.entity.Location;
import com.sportclusters.sportclusters.errors.UserNotFoundException;
import com.sportclusters.sportclusters.security.model.User;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import com.sportclusters.sportclusters.repositories.EventRepository;
import com.sportclusters.sportclusters.services.eventService.EventService;
import com.sportclusters.sportclusters.services.eventService.model.LocationGet;
import com.sportclusters.sportclusters.services.locationService.LocationService;
import com.sportclusters.sportclusters.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import javax.validation.ConstraintViolationException;

import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
public class EventServiceTest {


    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EventService eventService() {
            return new EventService();
        }

        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            return new MethodValidationPostProcessor();
        }
    }


    @Autowired
    private EventService eventService;


    @MockBean
    private EventRepository eventRepositoryMock;


    @MockBean
    private UserService userServiceMock;


    @MockBean
    private LocationService locationServiceMock;


    // without an owner
    @Test(expected = ConstraintViolationException.class)
    public void addEvent_WithoutOwnerTest() throws UserNotFoundException {

        EventAddReq req = new EventAddReq();
        LocationGet l = new LocationGet();
        l.setLocation(UUID.randomUUID());
        req.setLocation(l);

        Event e = eventService.addEvent(req);

    }



    // with an owner that doesn't exist in DB
    @Test(expected = UserNotFoundException.class)
    public void addEvent_WithWrongOwner() throws UserNotFoundException {

        EventAddReq req = new EventAddReq();
        Date now = new Date();

        LocationGet l = new LocationGet();
        l.setLocation(UUID.randomUUID());
        req.setLocation(l);
        req.setOwner(UUID.randomUUID());
        req.setDate(now);


        when(userServiceMock.findUser(req.getOwner())).thenReturn(null);

        eventService.addEvent(req);

    }



    // without StartDate
    @Test(expected = ConstraintViolationException.class)
    public void addEvent_WithoutDate() throws UserNotFoundException {

        EventAddReq req = new EventAddReq();
        Date now = new Date();

        LocationGet l = new LocationGet();
        l.setLocation(UUID.randomUUID());
        req.setLocation(l);
        req.setOwner(UUID.randomUUID());

        User u = new User();
    //    u.setId(10L);
        u.setId(UUID.randomUUID().toString().replace("-",""));
        u.setUsername("asd");

        when(userServiceMock.findUser(req.getOwner())).thenReturn(u);

        eventService.addEvent(req);

    }




    // with ok input
    @Test
    public void addEvent_WithGoodOwner_EventLocationId() throws UserNotFoundException {

        EventAddReq req = new EventAddReq();
        Date now = new Date();

        LocationGet l = new LocationGet();
        l.setLocation(UUID.randomUUID());

        req.setLocation(l);
    //    req.setOwner(10L);
        req.setOwner(UUID.randomUUID());
        req.setDate(now);


        User u = new User();
        u.setId(UUID.randomUUID().toString().replace("-",""));
        when(userServiceMock.findUser(req.getOwner())).thenReturn(u);



        Location location = new Location();
        location.setId(UUID.randomUUID());
        when(locationServiceMock.findLocation(req.getLocation().getLocation())).thenReturn(location);


        Event e = new Event();
        e.setLocation(location);
        e.setOwner(u);
        e.setDate(now);

        when(eventRepositoryMock.save(any(Event.class))).thenReturn(e);

        Event res = eventService.addEvent(req);
        Assert.assertEquals(e,res);

    }




}
