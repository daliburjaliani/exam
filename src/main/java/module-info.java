module com.example.exam{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens com.example.exam to javafx.fxml;
    exports com.example.exam;
}