module ieslosmontecillos.ejercicio5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ieslosmontecillos.ejercicio5 to javafx.fxml;
    exports ieslosmontecillos.ejercicio5;
}