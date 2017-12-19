package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Employee;
import application.CacheData;
import application.Main;
import application.Navigator;
import dao.CertificateDAO;


public class StatisticsController implements Initializable{

	@FXML private Rectangle balk;
	@FXML private BarChart<String, Integer> barChart;
	@FXML private CategoryAxis xAxis;
	
	private ObservableList<String> empNames = FXCollections.observableArrayList();
	private ObservableList<Integer> empCerts = FXCollections.observableArrayList();

	//backbutton
	@FXML protected void toHome(ActionEvent e) {
			Navigator.loadVista(Navigator.HomeView);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		int certOne;
		int certTwo;
		int certThree;
		int certFour;
		int certFive;
		
		CertificateDAO cdao = new CertificateDAO();
		
		for (Employee x : CacheData.employees) {
			empNames.add(x.getFullName());
			empCerts.add(cdao.getAmountByEmpId(x.getEmployeeId()));
		}
		
		xAxis.setCategories(empNames);
		xAxis.setTickLabelRotation(-90);
		
		// Count the number of people having their birthday in a specific month.
        int[] certCounter = new int[empNames.size()];
        
        for (int i = 0; i < empCerts.size(); i++) {
            certCounter[i] = empCerts.get(i);
        }
		
        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < certCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(empNames.get(i), certCounter[i]));
        }
        
       barChart.getData().add(series);
	}
	

}
