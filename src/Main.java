import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
        StackPane stack = new StackPane();
        Pane pane = new GridPane();


        Text hora = new Text(Time.getTime(TimeServices.getServerTime()));
        hora.setFont(Font.font("Trebuchet MS",65));
        hora.setTranslateX(180);
        hora.setTranslateY(135);
        pane.getChildren().add(hora);
        stack.getChildren().add(pane);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                     hora.setText(Time.getTime(TimeServices.getServerTime()));
                });
            }
        }, 0, 1000);


        Scene scene = new Scene(stack, 450, 300);
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
