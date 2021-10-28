package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService cm;

    public CustomerController(CustomerService cm) {
        this.cm = cm;
    }

    @PostMapping("/vlucht/zoek")
    public void flightsAvailableFind(){}

    @GetMapping("/vlucht/inzien")
    public void flightsAvailableView(){}

    @PostMapping("/vlucht/kies")
    public void flightsAvailablePick(){}

    @PostMapping("/gegevens")
    public void customerDetailsFill(){}

    @PostMapping("/bevestig")
    public void confirmBooking(){}
}
