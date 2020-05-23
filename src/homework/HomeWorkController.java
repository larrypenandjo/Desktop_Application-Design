/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Larry
 */
public class HomeWorkController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private HBox hboxTop;
    @FXML
    private HBox hboxBottom;
    @FXML
    private HBox hboxDashboard;
    @FXML
    private ScrollPane scrollPaneMenu;
    @FXML
    private VBox vboxMenu;
    @FXML
    private HBox chartsHbox;
    @FXML
    private LineChart<String, Number> salesChart;
    @FXML
    private BarChart<String, Number> emailSubsChart;
    @FXML
    private LineChart<?, ?> tasksChart;
    @FXML
    private HBox notificationsHbox;
    @FXML
    private JFXButton bugsBtn;
    @FXML
    private JFXButton websiteBtn;
    @FXML
    private JFXButton serverBtn;
    @FXML
    private Pane serverPane;
    @FXML
    private Pane websitePane;
    @FXML
    private Pane bugsPane;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private AnchorPane testPane;
    @FXML
    private Pane settingsPopup;
    @FXML
    private Pane sidebarFilters;
    @FXML
    private Circle sidebarLila;
    @FXML
    private JFXButton downloadBtn;
    @FXML
    private JFXButton getproBtn;
    @FXML
    private JFXButton docuBtn;
    @FXML
    private Circle sidebarBlue;
    @FXML
    private Circle sidebarGreen;
    @FXML
    private Circle sidebarRed;
    @FXML
    private Circle sidebarOrange;
    
    private List<Circle> circleElements = new ArrayList<>(Arrays.asList(sidebarBlue, sidebarLila, sidebarGreen, sidebarRed, sidebarOrange));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        scrollPane.widthProperty().addListener(new ChangeListener<Number>(){
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
////                oldValue = mainPane.getScene().getWindow().getWidth();
//                newValue = scrollPane.getScene().getWidth();
////                mainPane.setPrefWidth((double) newValue);
//                System.out.println("scrollPane width: "+newValue);
//            }            
//        });

        scrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                oldValue = mainPane.getScene().getWindow().getWidth();
                newValue = scrollPane.getHvalue();
//                mainPane.setPrefWidth((double) newValue);
                System.out.println("scrollPane width: " + newValue);
            }
        });

        vboxMenu.prefHeightProperty().bind(scrollPaneMenu.heightProperty());
        mainPane.prefWidthProperty().bind(scrollPane.widthProperty());
        mainPane.prefHeightProperty().bind(scrollPane.heightProperty());
//        hboxTop.prefWidthProperty().bind(testPane.widthProperty());
//        hboxBottom.prefWidthProperty().bind(testPane.widthProperty());
        hboxDashboard.prefWidthProperty().bind(scrollPane.widthProperty());
        chartsHbox.prefWidthProperty().bind(scrollPane.widthProperty());
        notificationsHbox.prefWidthProperty().bind(scrollPane.widthProperty());
//        scrollPane.setMaxWidth(1035);
//        System.out.println("Hbar value" +scrollPane.hvalueProperty().getValue());
        System.out.println("Hbar value" + scrollPane.hvalueProperty().get());
        if (scrollPane.hvalueProperty().get() >= scrollPane.getHmax()) {
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }

        /*Line Chart*/
        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Open");
        //populating the series with data
        series1.getData().add(new XYChart.Data("M", 10));
        series1.getData().add(new XYChart.Data("T", 20));
        series1.getData().add(new XYChart.Data("W", 5));
        series1.getData().add(new XYChart.Data("T", 18));
        series1.getData().add(new XYChart.Data("F", 21));
        series1.getData().add(new XYChart.Data("S", 17));
        series1.getData().add(new XYChart.Data("S", 39));

        salesChart.getData().addAll(series1);

        /*Bar Chart*/
        NumberAxis yAxis = new NumberAxis();
        CategoryAxis xAxis = new CategoryAxis();

        emailSubsChart.setTitle("Country Summary");
        xAxis.setLabel("Value");
        yAxis.setLabel("Country");

        XYChart.Series barSeries1 = new XYChart.Series();
        barSeries1.setName("Tesla Model S");
        barSeries1.getData().add(new XYChart.Data("Jan", 550));
        barSeries1.getData().add(new XYChart.Data("Feb", 450));
        barSeries1.getData().add(new XYChart.Data("Mar", 350));
        barSeries1.getData().add(new XYChart.Data("Apr", 781));
        barSeries1.getData().add(new XYChart.Data("May", 550));
        barSeries1.getData().add(new XYChart.Data("Jun", 550));
        barSeries1.getData().add(new XYChart.Data("Jul", 410));
//        barSeries1.getData().add(new XYChart.Data("Aug", 650));
//        barSeries1.getData().add(new XYChart.Data("Sep", 450));
//        barSeries1.getData().add(new XYChart.Data("Oct", 600));
//        barSeries1.getData().add(new XYChart.Data("Nov", 750));
//        barSeries1.getData().add(new XYChart.Data("Dec", 800)); 

        emailSubsChart.getData().addAll(barSeries1);

                
        for (Circle circle : circleElements) {

//            circle.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    circle.setStyle("-fx-stroke: #0000FF;");                  
//                }
//            });
//            circle.setOnMouseEntered((e) -> {
//                circle.setStyle("-fx-stroke: #0000FF;");
//            });
//            circle.setOnMouseExited((e) -> {
//                circle.setStyle("-fx-stroke: #FFFFFF;");
//            });
//
//            circle.setOnMouseClicked((e) -> {
//                circle.setStyle("-fx-stroke: #0000FF;");
//            });
        }

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Circle circle : circleElements) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED) && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        circle.setStyle("-fx-stroke: #0000FF;");
                    }
                    if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
                        circle.setStyle("-fx-stroke: #0000FF;");
                        if (event.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
                            circle.setStyle("-fx-stroke: #FFFFFF;");
                        }
                    }
                }
            }
        };

    }

    @FXML
    private void displayBugs(ActionEvent event) {
        if (!bugsPane.isVisible()) {
            bugsPane.setVisible(true);
        }
        websitePane.setVisible(false);
        serverPane.setVisible(false);
    }

    @FXML
    private void displayWebsite(ActionEvent event) {
        if (!websitePane.isVisible()) {
            websitePane.setVisible(true);
        }
        bugsPane.setVisible(false);
        serverPane.setVisible(false);
    }

    @FXML
    private void displayServer(ActionEvent event) {
        if (!serverPane.isVisible()) {
            serverPane.setVisible(true);
        }
        websitePane.setVisible(false);
        bugsPane.setVisible(false);
    }

    @FXML
    private void sidebarLilaEntered(MouseEvent event) {
        sidebarLila.setStyle("-fx-stroke: #0000FF;");
    }

    @FXML
    private void sidebarLilaClicked(MouseEvent event) {
//        sidebarLila.setStyle("-fx-stroke: #0000FF;");     
    }

    @FXML
    private void sidebarLilaExit(MouseEvent event) {
        sidebarLila.setStyle("-fx-stroke: #FFFFFF;");
    }

    @FXML
    private void sidebarBlueEntered(MouseEvent event) {
    }

    @FXML
    private void sidebarBlueClicked(MouseEvent event) {
        sidebarBlue.setStyle("-fx-stroke: #0000FF;");
    }

    @FXML
    private void sidebarGreenEntered(MouseEvent event) {
    }

    @FXML
    private void sidebarGreenClicked(MouseEvent event) {
    }

    @FXML
    private void sidebarRedEntered(MouseEvent event) {
    }

    @FXML
    private void sidebarRedClicked(MouseEvent event) {
    }

    @FXML
    private void sidebarOrangEntered(MouseEvent event) {
    }

    @FXML
    private void sidebarOrangeClicked(MouseEvent event) {
    }

    @FXML
    private void settingsBtnOnMouseCliked(MouseEvent event) {
        if(sidebarFilters.isVisible()){
            sidebarFilters.setVisible(false);
        }
        else{
            sidebarFilters.setVisible(true);
        }
    }
}
