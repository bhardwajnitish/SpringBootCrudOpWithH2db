package com.geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.geo.model.Book;
import com.geo.model.Book.BookType;

@SpringBootTest
public class BookTestApplication extends AbstractTest {

	@Test
	public void addBook() throws Exception {
		String uri = "/book";

		Book book = new Book("Java", 2014, BookType.Novel.name());

		String inputJson = super.mapToJson(book);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("Added book - " + result);
	}

	@Test
	public void getBooks() throws Exception {
		String uri = "/books";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Book[] booklist = super.mapFromJson(content, Book[].class);
		assertTrue(booklist.length > 0);
	}

}
