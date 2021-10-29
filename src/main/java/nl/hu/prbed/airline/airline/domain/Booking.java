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

    @OneToOne
    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Customer> customer;


    public Booking(Class bookingClass, Customer customer) {
        this();
        this.bookingClass = bookingClass;
        this.customer.add(customer);
    }

    public Booking() {
        this.customer = new ArrayList<>();
    }
}
