package com.geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.geo.model.Author;
import com.geo.model.Magazine;
import com.geo.model.Magazine.MagazineType;
import com.geo.model.Publication;

@SpringBootTest
public class MagazineTestApplication extends AbstractTest {

	@Test
	public void addMagazine() throws Exception {
		String uri = "/magazine";
		
		Publication magazine = new Magazine("India Today", 1990, MagazineType.Printed.name());
		Author author = new Author("Stephen King");
		magazine.addAuthor(author);
		
		String inputJson = super.mapToJson(magazine);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);		
	}

	@Test
	public void getMagazines() throws Exception {
		String uri = "/magazines";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Magazine[] magazinelist = super.mapFromJson(content, Magazine[].class);
		assertTrue(magazinelist.length > 0);
	}
	
}
