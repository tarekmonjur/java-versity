package Admin.Services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Tarek Monjur on 1/2/2018.
 */
public class MailService {

    private static String host = "smtp.mailtrap.io";
    private static int port = 2525;
    private static String userName = "78d0aeba399bf7";
    private static String password = "720dce2df88c57";
    private static String from = "tarekmonjur@gmail.com";

    public static int send(String to, String subject, String body)
    {
        int result = 0;
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", true);

        Session sessions = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(userName, password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(sessions);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
//            message.setText(body); // for plain text
            message.setContent(body, "text/html");

            Transport.send(message);
            result = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
