module com.example.trelloquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.trelloquiz to javafx.fxml;
    exports com.example.trelloquiz;
}