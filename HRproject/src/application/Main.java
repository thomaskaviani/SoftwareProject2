package application;
	

import java.io.IOException;

import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import controller.MainController;

public class Main extends Application {
	
	public static Stage mainStage;
	public static String color;
	
	@Override
	public void start(Stage stage) throws Exception {
		 
		mainStage = stage;
		mainStage.setTitle("HR - Application");
		mainStage.getIcons().add(new Image("images/reflex_icon.png"));
		mainStage.setScene(createScene(loadMainPane()));
		mainStage.setMaximized(true);
		
		mainStage.show();
		
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
	}
	
	
	private Pane loadMainPane() throws IOException {
        
		FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MainView));

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);

        Navigator.loadVista(Navigator.LoadingView);

        return mainPane;
    }
	
	
	private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        
        return scene;
    }
	
	
	
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException, TransformerException {
		
		launch(args); 

	}
}
