package org.virtusa.numbertowords.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.connector.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.virtusa.numbertowords.service.NumberToWordService;

import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberToWordControllerTest {

	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext webappcont;
	@Mock
	private NumberToWordService numbertowordservice;
	
	ObjectMapper om=new ObjectMapper();
	
	@Before
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webappcont).build();
	}

	@Test
	public void nummbertowordtest() throws Exception {
		MvcResult result = mockmvc
		.perform(get("/numbertowordmapping/{number}").content(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk()).andReturn();
		
		String resultcontent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultcontent,Response.class);
		Assert.assertTrue(response.getStatus()==200);
	}
}
