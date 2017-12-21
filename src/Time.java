import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static String getTime(Date date) {
        String hora = new SimpleDateFormat("H:mm:ss").format(date);
        String[] formating = hora.split(":");
        Integer hour = Integer.parseInt(formating[0]);
        if (hour > 12){
            hour = Math.abs(hour-12);
            return hour + ":" + formating[1] + ":" + formating[2];
        }
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
