package es.ieslosmontecillos.ejemplopathtransition;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Ejercicio de ejemplo para trabajar con animaciones
 * @author Francisco Manuel Gonzalez Martin
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)
    {
        Circle circle = new Circle(50);
        Rectangle rectangle = new Rectangle(10, 20);
        Pane root = new Pane();
        PathTransition transition = new PathTransition();

        //Colores
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        rectangle.setFill(Color.ORANGE);

        //Añadir componentes al contenedor
        root.getChildren().add(circle);
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Ejemplo path transition");
        stage.setScene(scene);
        stage.show();

        /*
            Centramos el circulo
            Nota: hacer esto antes de ejecutar la animacion ya que PathTransition no permite modificaciones
            mientras se este ejecutando la animacion
         */
        circle.setCenterX(scene.getWidth() / 2);
        circle.setCenterY(scene.getHeight() / 2);

        //Cuando pulsemos el circulo paramos la animacion
        circle.setOnMousePressed(_ -> transition.pause());

        //Cuando dejemos de pulsarlo seguira la animacion
        circle.setOnMouseReleased(_ -> transition.play());

        //Configuramos la animacion
        transition.setDuration(Duration.millis(4000));
        transition.setPath(circle);
        transition.setNode(rectangle);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setCycleCount(Integer.MAX_VALUE);

        //Ejecutamos la animacion cuando ya se haya mostrado la escena si no no funciona
        transition.play();
    }

    public static void main(String[] args) {
        launch();
    }
}