package com.geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
public class AuthorTestApplication extends AbstractTest {

	@Test
	public void addAuthor() throws Exception {
		String uri = "/authors";
		Author author = new Author();
		author.setName("Stephen King");

		Book book1 = new Book("The Stand", 1990, BookType.Novel.name());
		Book book2 = new Book("The Dark Tower III: The Waste Lands", 1990, BookType.Novel.name());
		author.addBook(book1);
		author.addBook(book2);
		
		Comics comics = new Comics("Death of Superman", 1990, "Superman");
		author.addComics(comics);
		
		Magazine magazine = new Magazine("India Today", 1990, MagazineType.Printed.name());
		author.addMagazine(magazine);

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
	
}
