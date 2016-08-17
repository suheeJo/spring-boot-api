package com.shjo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApiApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void requestbodyPost() throws Exception {
		// exceptionHandler: O, interceptor: O
		mockMvc.perform(post("/test5").header("access_key", "shjo")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"id\":\"1\", \"age\":\"2\"}"))
				.andExpect(status().isOk())
				.andDo(print());	

		// exceptionHandler: O, interceptor: O
		mockMvc.perform(post("/test5").header("access_key", "shjo")
						.contentType(MediaType.APPLICATION_JSON)
						.param("id", "1"))
				.andExpect(status().is(400))
				.andDo(print());
		
		// exceptionHandler: O, interceptor: X
		mockMvc.perform(delete("/test5").header("access_key", "shjo"))
				.andExpect(status().is(405))
				.andDo(print());
	}
	
	@Test
	public void pathVariableGet() throws Exception {
		// 404 에러는 멀 해도 interceptor 안탐
		// exceptionHandler: X (404 exception handler 안만듬), interceptor: X
		mockMvc.perform(get("/test4").header("access_key", "shjo"))
				.andExpect(status().is(404))
				.andDo(print());
	}
	
	@Test
	public void requestParamGet() throws Exception {
		// exceptionHandler: O, interceptor: O
		mockMvc.perform(get("/test3").header("access_key", "shjo"))
				.andExpect(status().is(400))
				.andDo(print());		
	}
	
	@Test
	public void modelAttriGet() throws Exception {
		// exceptionHandler: O, interceptor: O
		mockMvc.perform(get("/test2").header("access_key", "shjo")
						.param("id", "whtngml"))
				.andExpect(status().is(400))
				.andDo(print());
	}

	@Test
	public void 일반get() throws Exception {
		// exceptionHandler: O, interceptor: O
		mockMvc.perform(get("/test"))
				.andExpect(status().is(401))
				.andDo(print());
		
		// http method 변경 시 interceptor 를 안타게 된다
		// exceptionHandler: O, interceptor: X
		mockMvc.perform(post("/test").header("access_key", "shjo"))
				.andExpect(status().is(405))
				.andDo(print());
	}

}
