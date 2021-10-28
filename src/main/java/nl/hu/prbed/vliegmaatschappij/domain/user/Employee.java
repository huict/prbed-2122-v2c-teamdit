package nl.hu.prbed.vliegmaatschappij.domain.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Component
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    enum permissionLevel {
        LOW,
        MEDIUM,
        HIGH
    }

}