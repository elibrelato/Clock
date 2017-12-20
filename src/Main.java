import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();



        Date dateToFormat = Time.getTime();
        String f = new SimpleDateFormat("H:mm:ss").format(dateToFormat);
        Text hora = new Text(f);
        hora.setFont(Font.font("Trebuchet MS",25));
        gridPane.add(hora,0,2);












        Scene scene = new Scene(gridPane, 450, 300);
        primaryStage.setTitle("Clockito");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
