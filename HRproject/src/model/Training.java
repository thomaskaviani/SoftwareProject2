package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Training {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int trainingId;
	
	@Column
	private String name;

	@Column
	private String goal;
	@Column
	private int arch;
	
	//List<Session> sessions = new ArrayList<Session>();
	//List <Certificate> certificate = new ArrayList<Certificate>();
	//List<Book> books = new ArrayList<Book>();
	//private Survey survey;
	
	public Training() {
		
	}
	
	public Training(String name, String description) {
		this.name = name;
		this.goal = description;
	}
	
	
	
	public int getArch() {
		return arch;
	}


	public void setArch(int arch) {
		this.arch = arch;
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

	public String getGoal() {
		return goal;
	}

	public void setGoal(String description) {
		this.goal = description;
	}
	
	@Override
	public String toString() {
		return "\n\nID:" + getTrainingId() + "\n" + getName() + " " + getGoal();
	}
	
	/*
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
