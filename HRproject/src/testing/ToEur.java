package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.GoogleBooks;

class ToEur {

	@Test
	void test() {
		double output = GoogleBooks.toEur(1);
		System.out.println(GoogleBooks.toEur(1));
		assertEquals(1.13, output);
	}

}
