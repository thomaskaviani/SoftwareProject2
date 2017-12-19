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
import javafx.scene.chart.NumberAxis;
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
	@FXML private CategoryAxis xAxis;
	@FXML private NumberAxis yAxis;
	@FXML private BarChart<String, Integer> barChart;
	
	private ObservableList<String> empNames = FXCollections.observableArrayList();
	private ObservableList<Integer> empCerts = FXCollections.observableArrayList();

	//backbutton
	@FXML protected void toHome(ActionEvent e) {
			Navigator.loadVista(Navigator.HomeView);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		
        
		CertificateDAO cdao = new CertificateDAO();
		
		for (Employee x : CacheData.employees) {
			empNames.add(x.getFullName());
			empCerts.add(cdao.getAmountByEmpId(x.getEmployeeId()));
		}
		
		//X-as
		xAxis.setLabel("Employee");       
		xAxis.setCategories(empNames);
		xAxis.setTickLabelRotation(-90);


		
		//Y-as
		yAxis.setLabel("Certificates");
		yAxis.setMinorTickVisible(false);
		yAxis.setAutoRanging(false);
		yAxis.setTickUnit(1.0);
		
		int max = 0;
        int[] certCounter = new int[empNames.size()];
        for (int i = 0; i < empCerts.size(); i++) {
            certCounter[i] = empCerts.get(i);
            if (certCounter[i] > max) {
            	max = certCounter[i];
            }
        }
        max++;
        
        yAxis.setUpperBound(max);
		
        //XYchart
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for (int i = 0; i < certCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(empNames.get(i), certCounter[i]));
        }
        
        barChart.setLegendVisible(false);
        barChart.setTitle("Certificates per employee");
        barChart.getData().add(series);
	}
	

}
