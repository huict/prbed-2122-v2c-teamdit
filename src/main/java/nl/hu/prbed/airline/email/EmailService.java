package nl.hu.prbed.airline.email;

import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.customer.domain.Customer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(String to, Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();
        Customer customer = booking.getCustomer();

        String standardMessage = "Dear "+ customer.getFirstName() + " " +
                customer.getLastName() +
                " this is a confirmation for the following booking:\n\n"
                + booking;

        message.setFrom("teamditcj@gmail.com");
        message.setTo(to);
        message.setSubject("Booking confirmed");
        message.setText(standardMessage);

        emailSender.send(message);
    }
}
