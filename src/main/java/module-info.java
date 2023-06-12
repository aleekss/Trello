module com.example.trelloquiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trelloquiz to javafx.fxml;
    exports com.example.trelloquiz;
}