module com.example.book6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.book6 to javafx.fxml;
    exports com.example.book6.ch1;
    opens com.example.book6.ch1 to javafx.fxml;
    exports com.example.book6.ch2;
    opens com.example.book6.ch2 to javafx.fxml;
    exports com.example.book6;
    exports com.example.book6.ch3;
    opens com.example.book6.ch3 to javafx.fxml;
    exports com.example.book6.ch4;
    opens com.example.book6.ch4 to javafx.fxml;
    exports com.example.book6.ch5;
    opens com.example.book6.ch5 to javafx.fxml;
    exports com.example.book6.ch6;
    opens com.example.book6.ch6 to javafx.fxml;

}