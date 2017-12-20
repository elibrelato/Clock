import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        Text hora = new Text();


        Scene scene = new Scene(gridPane, 450,300);
        primaryStage.setTitle("Clockito");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
