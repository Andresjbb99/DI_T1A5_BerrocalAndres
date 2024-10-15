package ieslosmontecillos.ejercicio5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {

    // Círculo con radio inicial de 50
    private Circle circle = new Circle(50);

    @Override
    public void start(Stage primaryStage) {
        // Creo el StackPane y añado el círculo
        StackPane pane = new StackPane();
        pane.getChildren().add(circle);
        // Círculo sin relleno, solo la circunferencia
        circle.setFill(Color.TRANSPARENT);
        // Color negro para la circunferencia
        circle.setStroke(Color.BLACK); 

        // Botones de agrandar y reducir
        Button btnEnlarge = new Button("Enlarge");
        Button btnShrink = new Button("Shrink");

        // Creo un HBox para contener los botones
        // Espaciado de 10px entre los botones
        HBox hBox = new HBox(10); 
        // Centro los botones
        hBox.setAlignment(Pos.CENTER); 
        hBox.getChildren().addAll(btnEnlarge, btnShrink);

        // Creo un VBox para colocar el círculo arriba y los botones debajo
        // Espaciado de 20px entre el círculo y los botones
        VBox vBox = new VBox(20); 
        // Alineo ambos elementos al centro
        vBox.setAlignment(Pos.CENTER); 
        vBox.getChildren().addAll(pane, hBox);

        // Añado manejadores de eventos utilizando clases anidadas
        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());

        // Creo la escena y la muestro
        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Clase anidada para agrandar el círculo
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circle.setRadius(circle.getRadius() + 10); // Aumentar el radio en 10
        }
    }

    // Clase anidada para reducir el círculo
    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (circle.getRadius() > 10) { // Solo reducir si el radio es mayor que 10
                circle.setRadius(circle.getRadius() - 10); // Reducir el radio en 10
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
