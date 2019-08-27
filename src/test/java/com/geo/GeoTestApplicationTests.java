package com.geo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.geo.model.Author;
import com.geo.model.Book;
import com.geo.model.Book.BookType;
import com.geo.model.Comics;
import com.geo.model.Magazine;
import com.geo.model.Magazine.MagazineType;

@SpringBootTest
public class GeoTestApplicationTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void addAuthor() throws Exception {
		String uri = "/authors";
		Author author = new Author();
		author.setName("Atul Bhatia");

		Book book = new Book("Java", 2018, BookType.Novel.name());
		Comics comics = new Comics("Nagraj", 2014, "Nagraj");
		Magazine magazine = new Magazine("India Today", 2019, MagazineType.Printed.name());

		String inputJson = super.mapToJson(author);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		// String content = mvcResult.getResponse().getContentAsString();
		//assertEquals(content, "Product is created successfully");
	}

	@Test
	public void getAuthors() throws Exception {
		String uri = "/authors";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Author[] productlist = super.mapFromJson(content, Author[].class);
		assertTrue(productlist.length > 0);
	}

}
