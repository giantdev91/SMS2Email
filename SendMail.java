import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static void main(String[] args) {
        try {
            String host = "smtp.gmail.com";
//            String username = "polarbear91781014@gmail.com";
//            String password = "GoodLuck1014.";
            String username = "polarbear91781014@gmail.com";
            String password = "whbjlgroffjhhpmd";
            String toAddress = "giantdev91@gmail.com";
            String subject = "Test Email";
            String message = "This is a test email sent from Java.";

            // Set properties for Outlook SMTP server
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Create a session with Outlook SMTP server
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Create a new message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            msg.setSubject(subject);
            msg.setText(message);

            // Send the message
            Transport.send(msg);

            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}