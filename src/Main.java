import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();




        Date dateToFormat = Time.getTime();
        Text hora = new Text( new SimpleDateFormat("H:mm:ss").format(dateToFormat));
        hora.setFont(Font.font("Trebuchet MS",25));
        gridPane.add(hora,0,2);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date dateToFormat = Time.getTime();
                String newHora = new SimpleDateFormat("H:mm:ss").format(dateToFormat);
                Platform.runLater(() -> {
                     hora.setText(newHora);
                });
            }
        }, 0, 1000);













        Scene scene = new Scene(gridPane, 450, 300);
        primaryStage.setTitle("Clockito");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
