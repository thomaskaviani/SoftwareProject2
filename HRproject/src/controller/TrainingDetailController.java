package controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Address;
import model.Employee;
import model.Necessity;
import model.Participation;
import model.Sessions;
import model.Teacher;
import model.Training;
import model.Book;
import application.CacheData;
import application.Main;
import application.Navigator;
import dao.AddressDAO;
import dao.SessionsDAO;
import dao.TeacherDAO;
import dao.BookDAO;
import dao.NecessityDAO;


public class TrainingDetailController implements Initializable{

	@FXML private Rectangle balk;

	public static Training training;
	public static Book book = null;
	public Boolean amountBooks = false;
	@FXML private TextField aantalBooks;

	public static List<Employee> participationEmployees;

	@FXML private Label errorLabel;

	@FXML private Label trainingName;
	@FXML private Label infoTeacher;
	@FXML private Label infoAddress;
	@FXML private Label infoAddress2;
	@FXML private Label infoAddress3;
	@FXML private Label infoTime1;
	@FXML private Label infoTime2;
	@FXML private Label bookPrint;
	@FXML private Label succesSave;

	@FXML private TableView<Sessions> sessionTable;
	@FXML private TableView<Employee> participantTable;
	@FXML private TableColumn<Sessions, Date> sessionTableCol;
	@FXML private TableColumn<Employee, String> participantFirstNameCol;
	@FXML private TableColumn<Employee, String> participantLastNameCol;

	@FXML private TextField searchBar;


	@FXML protected void toAddSession(ActionEvent e) {

		AddSessionController.training = training;
		AddSessionController.normal = true;
		Navigator.loadVista(Navigator.AddSessionView);
	}


	//backbutton
	@FXML protected void toTrainingView(ActionEvent e) {
		resetVars();
		Navigator.loadVista(Navigator.SearchTrainingView);
	}


	@FXML protected void toAddBook(ActionEvent e) {
		Navigator.loadVista(Navigator.SearchBookView);
	}
	@FXML protected void toLocation(ActionEvent event) throws IOException {

		Sessions foo = sessionTable.getSelectionModel().getSelectedItem();

		if (foo != null) {
			AddressDAO adao = new AddressDAO();
			Address adres = adao.getById(foo.getAddressId());

			Pane root = FXMLLoader.load(getClass().getResource("/view/Map.fxml"));

			WebView browser = new WebView();
			WebEngine webEngine = browser.getEngine();

			webEngine.loadContent(genHtml(adres));


			Scene mapScene = new Scene(root);
			Stage mapStage = new Stage();
			mapStage.setTitle("Location");
			mapStage.setScene(mapScene);

			((Pane) mapScene.getRoot()).getChildren().add(browser);

			mapStage.show();
		} else {
			errorLabel.setText("No session selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}


	@FXML
	protected void toAddEmployee(ActionEvent e) {

		if (sessionTable.getSelectionModel().isEmpty()) {
			errorLabel.setText("No session selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		} else {
			AddEmployeeToSessionController.session = sessionTable.getSelectionModel().getSelectedItem();
			AddEmployeeToSessionController.training = training;
			AddEmployeeToSessionController.participationEmployees = new ArrayList<Employee>();
			Navigator.loadVista(Navigator.AddEmployeeToSessionView);
		}

	}


	@FXML public void clickSession(MouseEvent e) {

		errorLabel.setText("");

		participationEmployees = new ArrayList<Employee>();

		Sessions s = sessionTable.getSelectionModel().getSelectedItem();

		//Teachers checken
		Teacher t = null;
		Teacher t2 = null;
		for (Teacher x : CacheData.teachers) {
			if (x.getTeacherId() == s.getTeacherId()) {
				t2 = x;
			}
		}

		if (t2 == null) {
			TeacherDAO teachdao = new TeacherDAO();
			t = teachdao.getById(s.getTeacherId());
		} else {
			t = t2;
		}


		Address a = null;
		Address a2 = null;


		for (Address x : CacheData.addresses) {
			if (x.getAddressId() == s.getAddressId()) {
				a2 = x;
			}
		}

		if (a2 == null) {
			AddressDAO adao = new AddressDAO();
			a = adao.getById(s.getAddressId());
		} else {
			a = a2;
		}





		String bus;	
		if (a.getBus() == null) {
			bus = "";
		} else {
			bus = a.getBus();
		}

		infoTeacher.setText(t.getTeacherName() + "		Email: " + t.getEmail() + "		Company: " + t.getCompany());
		infoAddress.setText(a.getStreet() + " " + a.getNumber() + " " + bus);
		infoAddress2.setText(a.getPostalCode() + " " + a.getPlace());
		infoAddress3.setText(a.getCountry());

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateStart = df.format(s.getStartTime());
		String dateEnd = df.format(s.getEndTime());

		infoTime1.setText(dateStart);
		infoTime2.setText(dateEnd);

		//Employees die meedoen aan lijst toevoegen
		for (Participation p : CacheData.participations) {
			if (p.getSessionId() == s.getSessionId()) {
				if (CacheData.employees.size() >= Integer.valueOf(p.getEmpId())) {

					Employee emp = CacheData.employees.get(Integer.valueOf(p.getEmpId()) - 1);

					if (emp != null) {
						participationEmployees.add(emp);
					}

				}
			}
		}


		//Employees die meedoen tonen in participants tabel
		ObservableList<Employee> parts = FXCollections.observableArrayList(participationEmployees);
		participantTable.setItems(parts);

		participantFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		participantLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Boolean bookCheck = false;
		
		CacheData.setNecessity();
		
		for (Necessity x : CacheData.necessity) {
			
			if (x.getTrainingId() == TrainingDetailController.training.getTrainingId() && x.getArch() != 1) {
				
				bookCheck = true;
				this.amountBooks = true;
				aantalBooks.setPromptText(Integer.toString(x.getAmount()));
				BookDAO bdao = new BookDAO();
				TrainingDetailController.book = bdao.getById(x.getBookId());

				if (TrainingDetailController.book.getAuthor() != null) {
					bookPrint.setText(TrainingDetailController.book.getTitle() + " - " + TrainingDetailController.book.getAuthor());
				}
				if (TrainingDetailController.book.getAuthor() == null) {
					bookPrint.setText(TrainingDetailController.book.getTitle());
				}
			}
		}
		if (bookCheck == false){
			bookPrint.setText("");
		}
		if (TrainingDetailController.book != null && TrainingDetailController.book.getAuthor() != null) {
			bookPrint.setText(TrainingDetailController.book.getTitle() + " - " + TrainingDetailController.book.getAuthor());
		}
		if (TrainingDetailController.book != null && TrainingDetailController.book.getAuthor() == null) {
			bookPrint.setText(TrainingDetailController.book.getTitle());
		}



		balk.setFill(Color.valueOf(Main.color));
		trainingName.setText(training.getName());

		SessionsDAO sdao = new SessionsDAO();

		if (sdao.getByTraining(training.getTrainingId()) != null) {

			ObservableList<Sessions> sessions = FXCollections.observableArrayList(sdao.getByTraining(training.getTrainingId()));

			for (Sessions s : sessions) {
				s.setStartTimeString();
			}

			sessionTableCol.setCellValueFactory(new PropertyValueFactory<Sessions, Date>("startTimeString"));

			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<Sessions> filteredSessions = new FilteredList<>(sessions, p -> true);

			// 2. Set the filter Predicate whenever the filter changes.
			searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredSessions.setPredicate(session -> {

					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare first name and last name of every employee with filter text.
					String lowerCaseFilter = newValue.toLowerCase();

					if (session.getStartTimeString().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches start time.
					} 

					return false; // Does not match.
				});
			});

			// 3. Wrap the FilteredList in a SortedList. 
			SortedList<Sessions> sortedSessions = new SortedList<>(filteredSessions);

			// 4. Bind the SortedList comparator to the TableView comparator.
			// 	  Otherwise, sorting the TableView would have no effect.
			sortedSessions.comparatorProperty().bind(sessionTable.comparatorProperty());

			// 5. Add sorted (and filtered) data to the table.
			sessionTable.setItems(sortedSessions);
		}


	}


	//genereert de juiste maps html pagina
	private String genHtml(Address adr) {

		StringBuilder tHtml = new StringBuilder();
		StringBuilder tHtml2 = new StringBuilder();

		tHtml.append("<DOCTYPE html><html><head><title>Location</title><meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\"><meta charset=\"utf-8\"><style>#map {height: 100%;}html, body {height: 100%;margin: 0;padding: 0;}#floating-panel {position: absolute;top: 10px;left: 25%;z-index: 5;background-color: #fff;padding: 5px;border: 1px solid #999;text-align: center;font-family: 'Roboto','sans-serif';line-height: 30px;padding-left: 10px;}</style></head>");
		tHtml.append("<body><div id=\"map\"></div>");
		tHtml.append("<script>function initMap() {var map = new google.maps.Map(document.getElementById('map'), {zoom: 12,center: {lat: -34.397, lng: 150.644}});var geocoder = new google.maps.Geocoder();" + "\n");

		tHtml2.append("geocoder.geocode({'address': address}, function(results, status) {if (status === 'OK') {map.setCenter(results[0].geometry.location);var marker = new google.maps.Marker({map: map,position: results[0].geometry.location});} else {alert('Geocode was not successful for the following reason: ' + status);}});}</script>");
		tHtml2.append("<script async defer src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAj3MH0bJ7nfXK9gmnbUTdOLlZAkgsDkho&callback=initMap\"></script></body></html>");

		String x1 = tHtml.toString();
		String x2 = "var address = '" + adr.getFullAddress() + "';";
		String x3 = tHtml2.toString();
		String x = x1 + x2 + x3;

		return x;
	}
	@FXML protected void Delete() {
		NecessityDAO nDAO = new NecessityDAO();
		CacheData.setNecessity();
		for (Necessity x : CacheData.necessity) {
			if (TrainingDetailController.training.getTrainingId() == x.getTrainingId())
				nDAO.delete(nDAO.getById(x.getNecessityId()));
		}
		bookPrint.setText("");
		aantalBooks.setPromptText("Nr.");
		errorLabel.setText("Book is deleted!");
		errorLabel.setTextFill(Color.GREEN);
	}
	@FXML protected void Save() {
		//change amount!
		if (aantalBooks.getText().isEmpty() != true && bookPrint.getText().isEmpty() != true) {

			BookDAO bookDao = new BookDAO();
			bookDao.insert(TrainingDetailController.book);
			NecessityDAO nDAO = new NecessityDAO();
			Necessity nc = new Necessity();
			Training t = null;
			Boolean exists = false;

			for (Training x : CacheData.trainings) {
				if (x.getTrainingId() == TrainingDetailController.training.getTrainingId()) {
					t = x;
					nc.setTrainingId(t.getTrainingId());
				}
			}
			List<Book> books = bookDao.getAll();
			for (Book x : books) {
				if (x.getBookId() == TrainingDetailController.book.getBookId()) {
					nc.setBookId(x.getBookId());
				}
			}
			for (Necessity x : CacheData.necessity) {
				if (x.getTrainingId() == nc.getTrainingId() && x.getArch() != 1) {
					exists = true;
					x.setAmount(Integer.parseInt(aantalBooks.getText()));
					nDAO.update(x);
				}
			}
			if (exists == false) {
				nc.setAmount(Integer.parseInt(aantalBooks.getText()));
				nDAO.insert(nc);
			}

			errorLabel.setText("Book is saved!");
			errorLabel.setTextFill(Color.GREEN);
		} else {
			errorLabel.setText("Number required");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}

	public void resetVars() {
		training = null;
		book = null;
		participationEmployees = null;
	}

}
