package com.geo;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.geo.model.Author;

@SpringBootTest
public class AuthorTestApplication extends AbstractTest {

	@Ignore
	@Test
	public void addAuthor() throws Exception {
		String uri = "/authors";
		Author author = new Author("Stephen King");		

		String inputJson = super.mapToJson(author);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);		
	}

	@Test
	public void getAuthors() throws Exception {
		String uri = "/authors";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Author[] authorlist = super.mapFromJson(content, Author[].class);
		assertTrue(authorlist.length > 0);
	}
	
	@Test
	public void getAuthor() throws Exception {
		String uri = "/author/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Author author = super.mapFromJson(content, Author.class);
		assertNotNull(author);

	}
	
}
