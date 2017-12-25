package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;

class AddAuthor {

	@Test
	void test() {
		Book b = new Book();
		b.setAuthor("Author 1");
		b.addAuthor("Author 2");
		String output = b.getAuthor();
		assertEquals("Author 1Author 2", output);
	}

}
