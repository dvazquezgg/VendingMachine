module mx.edu.greengates.vendingmachine {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.edu.greengates.vendingmachine to javafx.fxml;
    exports mx.edu.greengates.vendingmachine;
}