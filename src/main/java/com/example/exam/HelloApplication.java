package com.example.exam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.net.CacheRequest;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        CarUtil.createTable();

        Text mainText = new Text("Enter Car Information");
        mainText.setLayoutX(100);
        mainText.setLayoutY(20);


        TextField name = new TextField();
        name.setLayoutX(100);
        name.setLayoutY(40);
        name.setPromptText("Name");

        TextField color = new TextField();
        color.setLayoutX(100);
        color.setLayoutY(80);
        color.setPromptText("Color");

        TextField year = new TextField();
        year.setLayoutX(100);
        year.setLayoutY(120);
        year.setPromptText("Year");

        Button insertButton = new Button("Insert");
        insertButton.setLayoutX(100);
        insertButton.setLayoutY(150);

        Text finalText = new Text();
        finalText.setLayoutX(100);
        finalText.setLayoutY(200);

        Button getChartButton = new Button("Get Chart");
        getChartButton.setLayoutY(40);
        getChartButton.setLayoutX(300);

        Text deleteText = new Text("Delete Item With Id");
        deleteText.setLayoutX(100);
        deleteText.setLayoutY(250);

        TextField itemId = new TextField();
        itemId.setPromptText("ID");
        itemId.setLayoutX(100);
        itemId.setLayoutY(270);

        Button deleteButton = new Button("Delete");
        deleteButton.setLayoutX(100);
        deleteButton.setLayoutY(300);

        Text deleteSuccess = new Text();
        deleteSuccess.setLayoutX(100);
        deleteSuccess.setLayoutY(350);

        Button clearData = new Button("Clear Data");
        clearData.setLayoutX(100);
        clearData.setLayoutY(380);

        Text dataText = new Text();
        dataText.setLayoutX(100);
        dataText.setLayoutY(430);

        Group root = new Group();

        root.getChildren().add(mainText);
        root.getChildren().add(name);
        root.getChildren().add(color);
        root.getChildren().add(year);
        root.getChildren().add(insertButton);
        root.getChildren().add(finalText);
        root.getChildren().add(getChartButton);
        root.getChildren().add(deleteText);
        root.getChildren().add(itemId);
        root.getChildren().add(deleteButton);
        root.getChildren().add(deleteSuccess);
        root.getChildren().add(clearData);
        root.getChildren().add(dataText);

        clearData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = CarUtil.clearData();
                dataText.setText(result);
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int carId = Integer.parseInt(itemId.getText());
                String result = CarUtil.deleteItem(carId);
                deleteSuccess.setText(result);
                itemId.clear();
            }
        });


        getChartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PieChart pieChart = new PieChart();
                pieChart.setData(CarUtil.readData());
                pieChart.setLayoutX(300);
                pieChart.setLayoutY(20);
                root.getChildren().add(pieChart);
            }
        });

        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String nameCar = name.getText();
                String colorCar = color.getText();
                int yearCar = Integer.parseInt(year.getText());

                String result = CarUtil.insert(new Car(nameCar, colorCar, yearCar));
                finalText.setText(result);


                name.clear();
                color.clear();
                year.clear();
            }
        });

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Exam!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}