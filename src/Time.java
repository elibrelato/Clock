import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static String getTime(Date date) {
        String hora = new SimpleDateFormat("H:mm:ss").format(date);
        return hora;
    }

    public static String getMeridian() {

        return null;
    }
}
