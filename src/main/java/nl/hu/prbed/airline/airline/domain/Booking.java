package nl.hu.prbed.airline.airline.domain;

import nl.hu.prbed.airline.airline.domain.user.Customer;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Component
public class Booking {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Class bookingClass;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Customer customer;


    public Booking(Class bookingClass, Customer customer) {
        this.bookingClass = bookingClass;
        this.customer = customer;
    }

    public Booking() {

    }
}
