package nl.hu.prbed.airline.email;

import nl.hu.prbed.airline.booking.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String to, Booking booking) {

        SimpleMailMessage message = new SimpleMailMessage();
        String standardMessage = "Dear "+ booking.getCustomer().getFirstName() +
                " " + booking.getCustomer().getLastName() +
                " this is a confirm message for the following made booking.\n"
                + "\nBooking information: "+ booking.toString();

        message.setFrom("teamditcj@gmail.com");
        message.setTo(to);
        message.setSubject("booking confirmed");
        message.setText(standardMessage);
        emailSender.send(message);

    }
}
