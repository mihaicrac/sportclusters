package com.sportclusters.sportclusters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.errors.EntityNotFoundException;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import com.sportclusters.sportclusters.services.eventService.EventServiceImpl;
import com.sportclusters.sportclusters.services.eventService.model.LocationSetReq;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportclustersApplicationTests {

	@Autowired
	private EventServiceImpl eventService;

	@Autowired
	private WebApplicationContext webApplicationContext;


	private MockMvc mockMvc;

	@Before
	public void configureSystemUnderTest() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void contextLoads() {
		System.out.print("adfas");
	}



	@Test
	public void TestAddEventService() throws EntityNotFoundException {
		EventAddReq req = new EventAddReq();

		LocationSetReq l = new LocationSetReq();
		l.setLocation(UUID.randomUUID());
		req.setLocation(l);
	//	req.setOwner(10L);

		try {
			Event e = eventService.addEvent(req);
		}catch(Exception e){
			req = null;
		}
	}

	@Ignore
	@Test()
	public void TestAddEvent() throws Exception{

		EventAddReq req = new EventAddReq();

		LocationSetReq l = new LocationSetReq();
		l.setLocation(UUID.randomUUID());
		req.setLocation(l);
		req.setDate(new Date().getTime());
		req.setOwner(UUID.randomUUID());

		ObjectMapper mapper = new ObjectMapper();


		ResultActions res = mockMvc.perform(
				post("/api/events")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(mapper.writeValueAsString(req))

		).andExpect(status().is5xxServerError());

	}



	
}
