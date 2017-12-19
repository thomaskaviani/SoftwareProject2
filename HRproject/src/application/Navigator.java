/*
 * Bronnen:
 * 
 * 
 * Navigator framework voor JavaFX door "Jewelsea": https://gist.github.com/jewelsea/6460130
 * 
 * */

package application;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

import controller.MainController;

public class Navigator {

	
	private static MainController mainController;
	
	public static String MainView    = "/view/MainView.fxml";
    public static String UserBoxView = "/view/UserBoxView.fxml";
    public static String EmptyView = "/view/EmptyView.fxml";
    public static String MenuBoxView = "/view/MenuBoxView.fxml";
    public static String LoadingView = "/view/LoadingView.fxml";
  
    public static final String AddQuestionSurveyView = "/view/AddQuestionSurveyView.fxml";
    public static final String SearchSurveyView = "/view/SearchSurveyView.fxml";
    public static final String SurveyDetailView = "/view/SurveyDetailView.fxml";
    public static final String QuestionResultView= "/view/QuestionResultView.fxml";
    public static final String EditQuestionSurveyView= "/view/EditQuestionSurveyView.fxml";
    
    
    public static String LoginView = "/view/LoginView.fxml";
    public static String EmployeeView = "/view/EmployeeView.fxml";
    public static String EmployeeDetailView = "/view/EmployeeDetailView.fxml";
    public static String AddTrainingView = "/view/AddTrainingView.fxml";
    public static String SearchTrainingView = "/view/SearchTrainingView.fxml";
    public static String TrainingDetailView = "/view/TrainingDetailView.fxml";
    public static String TrainingResultView = "/view/TrainingResultView.fxml";
    public static String ForgotPasswordView = "/view/ForgotPasswordView.fxml";
    public static String AddSessionView = "/view/AddSessionView.fxml";
    public static String AddEmployeeToSessionView = "/view/AddEmployeeToSessionView.fxml";
    public static String TrainingView = "/view/TrainingView.fxml";
    public static String HomeView = "/view/HomeView.fxml";
    public static String GeneralSettingsView = "/view/GeneralSettingsView.fxml";
    public static String AccountSettingsView = "/view/AccountSettingsView.fxml";
    public static String StyleOptionsView = "/view/StyleOptionsView.fxml";
    public static String AddCertificateView = "/view/AddCertificateView.fxml";
    public static String ShowCertificateView = "/view/ShowCertificateView.fxml";
    public static String TrainingRequestView = "/view/TrainingRequestView.fxml";
    public static String BookView = "/view/BookView.fxml";
    

    public static String SearchBookView = "/view/SearchBookView.fxml";
    
    
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
    
    public static void setViews() {
    	
    	MainView = "/view/MainView.fxml";
    	UserBoxView = "/view/UserBoxView.fxml";
        EmptyView = "/view/EmptyView.fxml";
        MenuBoxView = "/view/MenuBoxView.fxml";
        LoadingView = "/view/LoadingView.fxml";
        
        LoginView = "/view/LoginView.fxml";
        EmployeeView = "/view/EmployeeView.fxml";
        EmployeeDetailView = "/view/EmployeeDetailView.fxml";
        AddTrainingView = "/view/AddTrainingView.fxml";
        SearchTrainingView = "/view/SearchTrainingView.fxml";
        TrainingDetailView = "/view/TrainingDetailView.fxml";
        TrainingResultView = "/view/TrainingResultView.fxml";
        ForgotPasswordView = "/view/ForgotPasswordView.fxml";
        AddSessionView = "/view/AddSessionView.fxml";
        AddEmployeeToSessionView = "/view/AddEmployeeToSessionView.fxml";
        TrainingView = "/view/TrainingView.fxml";
        HomeView = "/view/HomeView.fxml";
        GeneralSettingsView = "/view/GeneralSettingsView.fxml";
        AccountSettingsView = "/view/AccountSettingsView.fxml";
        StyleOptionsView = "/view/StyleOptionsView.fxml";
        AddCertificateView = "/view/AddCertificateView.fxml";
        ShowCertificateView = "/view/ShowCertificateView.fxml";
        
        BookView = "/view/BookView.fxml";
        SearchBookView = "/view/SearchBookView.fxml";
        
        
    }
    
}