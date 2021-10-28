package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.EmployeeService;
import nl.hu.prbed.vliegmaatschappij.domain.Employee;
import org.dom4j.io.ElementModifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//voor HATEOS zie link https://www.youtube.com/watch?v=KIFncw4RtEY&ab_channel=AlmightyJava

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    //zoeken van vliegroute
    @GetMapping("/vliegroute")
    public ResponseEntity<Collection<Employee>> flightrouteView() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //vliegroute toevoegen
    @PostMapping("/vliegroute")
    public ResponseEntity<Collection<Employee>> flightrouteAdd() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //vliegroute aanpassen
    @PostMapping("/vliegroute")
    public ResponseEntity<Collection<Employee>> flightrouteEdit() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //zoeken van luchthavens
    @GetMapping("/luchthaven/inzien")
    public ResponseEntity<Collection<Employee>> airportView() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van luchthaven
    @PostMapping("/luchthaven/toevoegen")
    public ResponseEntity<Collection<Employee>> airportAdd() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van luchthaven
    @PostMapping("/luchthaven/aanpassen")
    public ResponseEntity<Collection<Employee>> airportEdit() {
      Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //zoeken van vliegtuig op basis van id
    @GetMapping("/vliegtuig")
    public ResponseEntity<Collection<Employee>> planeView() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van vliegtuig
    @PostMapping("/vliegtuig")
    public ResponseEntity<Collection<Employee>> planeAdd() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van vliegtuig op basis van id
    @PostMapping("/vliegtuig/aanpassen")
    public ResponseEntity<Collection<Employee>> planeEdit() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //zoeken van alle vluchten
    @GetMapping("/vlucht")
    public ResponseEntity<Collection<Employee>> flightView() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van vlucht
    @PostMapping("/vlucht")
    public ResponseEntity<Collection<Employee>> flightAdd() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van vlucht op basis van id/naam
    @PostMapping("/vlucht")
    public ResponseEntity<Collection<Employee>> flightEdit() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //annuleren van vlucht op basis van id
    @PostMapping("/vlucht")
    public ResponseEntity<Collection<Employee>> flightCancel() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
//            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //zoeken van boekingen
    @GetMapping("/boeking")
    public ResponseEntity<Collection<Employee>> bookingView() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van boeking
    @PostMapping("/boeking")
    public ResponseEntity<Collection<Employee>> bookingAdd() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van boeking op basis van id
    @PutMapping("/boeking")
    public ResponseEntity<Collection<Employee>> bookingEdit() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //zoeken van alle klanten
    @GetMapping("/klant")
    public ResponseEntity<Collection<Employee>> customerView() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van klant
    @PostMapping("/klant")
    public ResponseEntity<Collection<Employee>> customerAdd() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van klant op basis van id
    @PutMapping("/klant")
    public ResponseEntity<Collection<Employee>> customerEdit() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //zoeken van medewerkers
    @GetMapping("/medewerker")
    public ResponseEntity<Collection<Employee>> employeeView() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //toevoegen van medewerker
    @PostMapping("/medewerker")
    public ResponseEntity<Collection<Employee>> employeeAdd() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //aanpassen van medewerker
    @PostMapping("/medewerker")
    public ResponseEntity<Collection<Employee>> employeeEdit() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //verwijderen van medewerker
    @DeleteMapping("/medewerker")
    public ResponseEntity<Collection<Employee>> employeeDelete() {
          Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
