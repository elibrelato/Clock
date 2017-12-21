import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;
import java.util.Date;

public class TimeServices {
    public static Date getServerTime(){
        String host = "0.north-america.pool.ntp.org";
        NTPUDPClient client = new NTPUDPClient();

        try {
            client.open();
            InetAddress address = InetAddress.getByName(host);
            TimeInfo tf = client.getTime(address);
            Date date = new Date(tf.getMessage().getTransmitTimeStamp().getTime());
            if (date != null){
                client.setDefaultTimeout(5000);
                client.setSoTimeout(5000);
            }
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
        return null;
    }
}
