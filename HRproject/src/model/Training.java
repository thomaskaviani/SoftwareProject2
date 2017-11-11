package model;
import java.util.*;


public class Training {

	
	private int trainingId;
	private String name;
	private String description;
	//List<Book> books = new ArrayList<Book>();
	List<Session> sessions = new ArrayList<Session>();
	//List <Certificate> certificate = new ArrayList<Certificate>();
	//private Survey survey;
	
	//CONSTRUCTOR LATER TOEVOEGEN
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	/*
	 public void addBook (Book book)
	{
		this.books.add(Book);
	}
*/
}
