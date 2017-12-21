import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stack = new StackPane();
        Pane paneTime = new Pane();
        Pane paneMeri = new Pane();
        Pane paneToday = new Pane();
        //Here we get the Date from TimeServices and then we use it in Time to get only the time
        Text hora = new Text(Time.getTime(TimeServices.getServerTime()));
        hora.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,65));
        hora.setTranslateX(180);
        hora.setTranslateY(185);
        paneTime.getChildren().add(hora);

        //Now we get the PM or AM the same way we got the time
        Text meri = new Text(Time.getMeridian(TimeServices.getServerTime()));
        meri.setFont(Font.font("Trebuchet MS", FontWeight.BOLD,50));
        meri.setTranslateX(370);
        meri.setTranslateY(230);
        paneMeri.getChildren().add(meri);

        //We get the date in letters like "Day, Month Number" the same way we got the other two
        Text today = new Text(Time.getDate(TimeServices.getServerTime()));
        today.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM,35));
        today.setTranslateX(20);
        today.setTranslateY(80);
        paneToday.getChildren().add(today);




        stack.getChildren().addAll(paneTime, paneMeri, paneToday);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                     hora.setText(Time.getTime(TimeServices.getServerTime()));
                     meri.setText(Time.getMeridian(TimeServices.getServerTime()));
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
