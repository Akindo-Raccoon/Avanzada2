package Test;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import com.vonage.client.sms.MessageStatus;
import static com.vonage.quickstart.Util.configureLogging;
import static com.vonage.quickstart.Util.envVar;

/**
 *
 * @author manol
 */
public class hola {

    public static void main(String[] args) throws Exception {
        configureLogging();
        String VONAGE_API_KEY = envVar("6a81c822");
        String VONAGE_API_SECRET = envVar("uiIjNAnw153SMilB");
        String TO_NUMBER = envVar("573203414663");
        String VONAGE_BRAND_NAME = envVar("573203414663");

        VonageClient client = VonageClient.builder().apiKey("6a81c822").apiSecret("uiIjNAnw153SMilB").build();
        TextMessage message = new TextMessage("Vonage APIs",
                "573203414663",
                "A text message sent using the Vonage SMS API"
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }
    }
}
