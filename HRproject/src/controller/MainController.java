package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

	
	@FXML
	private VBox menuBox;
	
    @FXML
    private VBox contentBox;
    
    @FXML
    private VBox userBox;
    
    @FXML
    private static Button logoutButton;
    
    @FXML
	protected void doLogout(ActionEvent e) {
    	
    	if (LoginController.userLogged != null) {
    		LoginController.userLogged = null;
    		Navigator.loadVista(Navigator.LoginView);
    		Navigator.loadUserVista(Navigator.EmptyView);
    		Navigator.loadMenuVista(Navigator.EmptyView);
    	}
		
		
	}
    
	
    public void setContent(Node node) {
        contentBox.getChildren().setAll(node);
    }
    
    public void setContentMenu(Node node) {
        menuBox.getChildren().setAll(node);
    }
    
    public void setContentUser(Node node) {
        userBox.getChildren().setAll(node);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
    }

}
