package Modelo;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class NotificacionCelular {

    public static final String ACCOUNT_SID = System.getenv("AC18fa2e9feb4cf58ba8797e596c118a20");
    public static final String AUTH_TOKEN = System.getenv("e9527bf498c24bd8c54cb62d605d8417");
    public static final PhoneNumber myPhone = new PhoneNumber("+12679433060");

    public NotificacionCelular(String accountSid, String authToken) {

    }

    public void sendMessage(String number, String mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                myPhone,
                new PhoneNumber(number),
                mensaje)
                .create();

        System.out.println(message.getSid());
    }
}
