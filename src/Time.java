import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static String getTime(Date date) {
        String hora = new SimpleDateFormat("H:mm:ss").format(date);
        return hora;
    }

    public static String getMeridian(Date date) {
        String meri = new SimpleDateFormat("a").format(date);
        return meri;
    }
    public static String getDate(Date date){
        String today = new SimpleDateFormat("EEEEEEEEE, MMM d").format(date);
        return today;
    }
}
