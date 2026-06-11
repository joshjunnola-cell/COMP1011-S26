import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class MyApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");
        Scene scene = new Scene(label, 300, 200); // width=300, height=200
        primaryStage.setScene(scene);
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args); // Launches the application
    }
}