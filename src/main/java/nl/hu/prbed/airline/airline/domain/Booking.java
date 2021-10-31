package nl.hu.prbed.airline.airline.domain;

import nl.hu.prbed.airline.airline.domain.user.Customer;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Booking {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Class bookingClass;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Customer> customers;

    public Booking() {
    }

    public Booking( Class bookingClass, List<Customer> customers) {
        this.bookingClass = bookingClass;
        this.customers = customers;
    }
}
