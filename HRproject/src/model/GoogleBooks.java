/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package model;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;


import java.io.IOException;
import java.util.ArrayList;

/**
 * A sample application that demonstrates how Google Books Client Library for
 * Java can be used to query Google Books. It accepts queries in the command
 * line, and prints the results to the console.
 *
 * $ java com.google.sample.books.BooksSample [--author|--isbn|--title] "<query>"
 *
 * Please start by reviewing the Google Books API documentation at:
 * http://code.google.com/apis/books/docs/getting_started.html
 */
public class GoogleBooks {

	/**
	 * Be sure to specify the name of your application. If the application name is {@code null} or
	 * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
	 */
	private static final String APPLICATION_NAME = "Reflex-Books";

	public static double toEur(double price) {
		return (Math.round(price * 1.13167722* 100.0)) / 100.0;
	}

	private static ArrayList<Book> queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception {
		ClientCredentials.errorIfNotSpecified();
 
		// Set up Books client.
		final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
				.setApplicationName(APPLICATION_NAME)
				.setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
				.build();
		// Set query string and filter only Google eBooks.
		List volumesList = books.volumes().list(query);
		volumesList.setFilter("full");
		volumesList.setMaxResults((long)40);

		// Execute the query.
		Volumes volumes = volumesList.execute();
		if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
			return null;
		}
		ArrayList<Book> boeken = new ArrayList<Book>();

		// Output results.
		for (Volume volume : volumes.getItems()) {
			
			Book b = new Book();

			Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
			Volume.SaleInfo saleInfo = volume.getSaleInfo();
				
			//title
			b.setTitle(volumeInfo.getTitle());
			// Author(s).
			java.util.List<String> authors = volumeInfo.getAuthors();
			if (authors != null && !authors.isEmpty()) {
				for (int i = 0; i < authors.size(); ++i) {
					b.setAuthor(volumeInfo.getAuthors().get(i));
					if (i < authors.size() - 1) {
						b.addAuthor(", ");
					}
				}
			}
			// Description (if any).
			if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
				b.setDescription(volumeInfo.getDescription());
			}
			// Price (if any).
			if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
				b.setPrice(toEur(saleInfo.getListPrice().getAmount()));
			}
			boeken.add(b);
		}
		return boeken;
	}

	public static ArrayList<Book> searchBook(String query) {
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		try {
			// Parse command line parameters into a query.
			// Query format: "[<author|isbn|intitle>:]<query>"
			if (query.equals("")) {
				return null;			
			}
			try {
				return queryGoogleBooks(jsonFactory, query);
				// Success!
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}