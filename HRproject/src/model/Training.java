package model;
import java.util.*;


public class Training {

	
	private int trainingId;
	private String name;
	private String description;
	List<Book> books = new ArrayList<Book>();
	List<Session> sessions = new ArrayList<Session>();
	List <Certificate> certificate = new ArrayList<Certificate>();
	private Survey survey;
	
	//CONSTRUCTOR LATER TOEVOEGEN
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Training(int trainingId, String name, String description, List<Book> books, List<Session> sessions,
			List<Certificate> certificate, Survey survey) {
		super();
		this.trainingId = trainingId;
		this.name = name;
		this.description = description;
		this.books = books;
		this.sessions = sessions;
		this.certificate = certificate;
		this.survey = survey;
	}
	

	public Training(int trainingId, String name, String description, List<Session> sessions) {
		super();
		this.trainingId = trainingId;
		this.name = name;
		this.description = description;
		this.sessions = sessions;
	}

	public Training(int trainingId, String name, String description) {
		super();
		this.trainingId = trainingId;
		this.name = name;
		this.description = description;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Certificate> getCertificate() {
		return certificate;
	}

	public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public void addSession (Session session)
	{
		this.sessions.add(session);
	}
	public void deleteSession(Session session)
	{
		Iterator<Session> it = this.sessions.iterator();
	    while (it.hasNext()) {
	        if (it.next().getSessionId() == session.getSessionId()) {
	            it.remove();
	            break;
	        }
	    }
		
	}
	
	 public void addBook (Book book)
	{
		this.books.add(book);
	}

}
