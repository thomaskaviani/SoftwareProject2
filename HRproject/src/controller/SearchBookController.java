package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import model.GoogleBooks;
import model.Book;

public class SearchBookController implements Initializable {
	
	@FXML private Rectangle balk;
	
	@FXML private TableView<Book> tableView;
	
	@FXML private TextField searchBar;
	@FXML private Label errorLabel;
	
	@FXML private TableColumn<Book, String> bookTitleCol;
	
	@FXML private TableColumn<Book, String> bookAuthorCol;
	
	@FXML private TableColumn<Book, String> bookPriceCol;

	@FXML protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
	}

	@FXML protected void clickTrain(MouseEvent e) {
		errorLabel.setText("");
	}
	
	@FXML protected void Search() {
		ObservableList<Book> books = FXCollections.observableArrayList(GoogleBooks.searchBook(searchBar.getText()));
		
		bookTitleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		bookAuthorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		bookPriceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
		
		tableView.setItems(books);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		errorLabel.setText("");
		balk.setFill(Color.valueOf(Main.color));		
	}
	
	@FXML protected void addBook() {
		
	}

	
}
