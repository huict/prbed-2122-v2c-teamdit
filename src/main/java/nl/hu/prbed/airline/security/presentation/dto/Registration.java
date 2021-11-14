package nl.hu.prbed.airline.security.presentation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;

public class Registration {
    public Long id;

    @NotBlank
    public String username;

    @Size(min = 5)
    public String password;

    @NotBlank
    public String firstName;

    @NotBlank
    public String lastName;

    public Date dateOfBirth;

    public Long phoneNumber;

    public String emailAddress;

    public String nationality;
}
