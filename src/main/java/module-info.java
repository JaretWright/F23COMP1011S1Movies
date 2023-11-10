module com.example.f23comp1011s1movies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f23comp1011s1movies to javafx.fxml;
    exports com.example.f23comp1011s1movies;
}