package application;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

import controller.MainController;

public class Navigator {

    public static final String MainView    = "/view/MainView.fxml";
    public static final String UserBoxView = "/view/UserBoxView.fxml";
    public static final String EmptyView = "/view/EmptyView.fxml";
    public static final String MenuBoxView = "/view/MenuBoxView.fxml";


    public static final String LoginView = "/view/LoginView.fxml";
    
    
    //getweaked
    public static final String EmployeeView = "/view/EmployeeView.fxml";
    public static final String EmployeeDetailView = "/view/EmployeeDetailView.fxml";
    public static final String AddTrainingView = "/view/AddTrainingView.fxml";
    public static final String SearchTrainingView = "/view/SearchTrainingView.fxml";
    public static final String TrainingDetailView = "/view/TrainingDetailView.fxml";
    public static final String TrainingResultView = "/view/TrainingResultView.fxml";
    public static final String ForgotPasswordView = "/view/ForgotPasswordView.fxml";
    public static final String AddSessionView = "/view/AddSessionView.fxml";
    public static final String AddEmployeeToSessionView = "/view/AddEmployeeToSessionView.fxml";
    public static final String TrainingView = "/view/TrainingView.fxml";
    public static final String HomeView = "/view/HomeView.fxml";
    public static final String GeneralSettingsView = "/view/GeneralSettingsView.fxml";
    
    
    //todo
    public static final String AccountSettingsView = "/view/AccountSettingsView.fxml";
    public static final String StyleOptionsView = "/view/StyleOptionsView.fxml";

    
    
    public static final String TEST = "/view/test.fxml";



    private static MainController mainController;
    
    
    public static void setMainController(MainController mainController) {
        Navigator.mainController = mainController;
    }
    
    
    
    public static void loadVista(String fxml) {
        try {
        	
            mainController.setContent(FXMLLoader.load(Navigator.class.getResource(fxml)));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadMenuVista(String fxml) {
    	
    	try {
        	
            mainController.setContentMenu(FXMLLoader.load(Navigator.class.getResource(fxml)));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    public static void loadUserVista(String fxml) {
    	
    	try {
        	
            mainController.setContentUser(FXMLLoader.load(Navigator.class.getResource(fxml)));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
}