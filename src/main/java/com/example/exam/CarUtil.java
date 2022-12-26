package com.example.exam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarUtil {

    private CarUtil() {

    }

    private static final String CREATE = "CREATE TABLE IF NOT EXISTS CARS(" +
            "NAME VARCHAR(30)," +
            "COLOR VARCHAR(30)," +
            "YEAR INTEGER," +
            "ID INTEGER PRIMARY KEY AUTO_INCREMENT)";


    public static void createTable() {
        try {
            JDBCConfig.getStatement().executeUpdate(CREATE);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static String insert(Car car){

        String INSERT_TABLE = "INSERT INTO CARS(NAME, COLOR, YEAR) VALUES(" +
                "'"+ car.getName() + " ', '" +
                 car.getColor() + "'," +
                 car.getYear() +")";

        try {
            JDBCConfig.getStatement().executeUpdate(INSERT_TABLE);
            return "Item inserted successfully";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<PieChart.Data> readData(){

        String select = "SELECT YEAR, count(*) FROM CARS GROUP BY YEAR";

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();

        try{
            ResultSet result = JDBCConfig.getStatement().executeQuery(select);

            while (result.next()){
                observableList.add(new PieChart.Data(String.valueOf(result.getInt("YEAR")), result.getInt(2)));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return observableList;

    }
}
