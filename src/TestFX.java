import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class TestFX extends Application{

    public static void main(String[] args) {
        //Launches window/javafx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane board= new GridPane();

        int count = 0;
        double s = 100;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle(s, s, s, s);
                if (count % 2 == 0) {
                    r.setFill(Color.WHITE);
                }
                board.add(r, j, i);
                count++;
            }
        }

        Scene scene = new Scene(board);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
