package com.geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.geo.model.Author;
import com.geo.model.Comics;
import com.geo.model.Publication;

@SpringBootTest
public class ComicsTestApplication extends AbstractTest {

	@Test
	public void addComics() throws Exception {
		String uri = "/comics";

		Publication comics = new Comics("Death of Superman", 1990, "Superman");
		Author author = new Author("Stephen King");
		comics.addAuthor(author);

		String inputJson = super.mapToJson(comics);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);		
	}

	@Test
	public void getComics() throws Exception {
		String uri = "/comicses";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Comics[] comicslist = super.mapFromJson(content, Comics[].class);
		assertTrue(comicslist.length > 0);
	}
}
