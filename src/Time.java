import java.net.InetAddress;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class Time {
    public static Date getTime(){
        String host = "0.north-america.pool.ntp.org";
        NTPUDPClient client = new NTPUDPClient();
        try {
            InetAddress address = InetAddress.getByName(host);
            TimeInfo tf = client.getTime(address);
            Date date = new Date(tf.getMessage().getTransmitTimeStamp().getTime());
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
        return null;
    }
}
