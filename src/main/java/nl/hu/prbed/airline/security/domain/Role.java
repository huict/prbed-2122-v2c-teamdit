package nl.hu.prbed.airline.security.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    private static final List<String>
            allRoleNames = Arrays.asList(
            "ROLE_ADMIN",
            "ROLE_EMPLOYEE",
            "ROLE_USER"
    );

    public static List<String> getAllRoleNames() {
        return allRoleNames;
    }
}
