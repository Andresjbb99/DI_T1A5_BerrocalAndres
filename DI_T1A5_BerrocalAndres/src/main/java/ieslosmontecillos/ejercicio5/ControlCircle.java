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

    private Circle circle = new Circle(50); // Círculo con radio inicial de 50

    @Override
    public void start(Stage primaryStage) {
        // Crear el StackPane y añadir el círculo
        StackPane pane = new StackPane();
        pane.getChildren().add(circle);
        circle.setFill(Color.LIGHTBLUE);
        circle.setStroke(Color.BLACK);

        // Botones de agrandar y reducir
        Button btnEnlarge = new Button("Agrandar");
        Button btnShrink = new Button("Reducir");

        // Crear un HBox para contener los botones
        HBox hBox = new HBox(10); // Espaciado de 10px entre botones
        hBox.setAlignment(Pos.CENTER); // Centrar los botones
        hBox.getChildren().addAll(btnEnlarge, btnShrink);

        // Crear un VBox para colocar el círculo arriba y los botones debajo
        VBox vBox = new VBox(20); // Espaciado de 20px entre el círculo y los botones
        vBox.setAlignment(Pos.CENTER); // Alinear ambos elementos al centro
        vBox.getChildren().addAll(pane, hBox);

        // Añadir manejadores de eventos utilizando clases anidadas
        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());

        // Crear la escena y mostrarla
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
