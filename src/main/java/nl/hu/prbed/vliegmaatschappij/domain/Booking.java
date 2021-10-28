package nl.hu.prbed.vliegmaatschappij.domain;

import nl.hu.prbed.vliegmaatschappij.domain.user.Customer;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Component
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
