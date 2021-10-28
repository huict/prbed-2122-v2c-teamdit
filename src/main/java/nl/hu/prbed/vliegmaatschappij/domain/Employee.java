package nl.hu.prbed.vliegmaatschappij.domain;

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
public class Employee extends RepresentationModel<Employee> {
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

    @JsonCreator
    public Employee(@JsonProperty("id") Long id, @JsonProperty("firstname") String firstName, @JsonProperty("lastname") String lastName, @JsonProperty("birthday") Date dateOfBirth) {
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
