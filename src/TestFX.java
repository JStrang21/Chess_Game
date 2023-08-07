import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestFX extends Application {
    Button button;

    public static void main(String[] args) {
        //Launches window/javafx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Main window/stage title
        primaryStage.setTitle("Chess");

        button = new Button();
        button.setText("Click");

        StackPane layout= new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
