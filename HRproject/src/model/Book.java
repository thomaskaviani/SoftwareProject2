package model;

public class Book {
	
	
	private int bookId;
	private String title;
	private String author;
	private double price;
	private String edition;
	private String publisher;
	private int arch;
	
	public Book () {
		
	}
	
	public Book(int bookId, String title, String author, double price, String edition, String publisher) 
	{
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.edition = edition;
		this.publisher = publisher;
		this.arch = 0;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	
}