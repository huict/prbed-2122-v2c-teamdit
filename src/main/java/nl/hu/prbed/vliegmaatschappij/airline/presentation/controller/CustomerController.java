package nl.hu.prbed.vliegmaatschappij.airline.presentation.controller;

import nl.hu.prbed.vliegmaatschappij.airline.application.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService cm;

    public CustomerController(CustomerService cm) {
        this.cm = cm;
    }

//    //zoeken
//    @PostMapping("/vlucht")
//    public void flightsAvailableFind(){}
//
//    //beschikbare vluchten
//    @GetMapping("/vlucht/beschikbaar")
//    public void flightsAvailableView(){}
//
//    //beschikbare vlucht op basis van id
//    @PostMapping("/vlucht")
//    public void flightsAvailablePick(){}
//
//    //passagier gegevens op basis van id
//    @PostMapping("/gegevens")
//    public void customerDetailsFill(){}
//
//    //bevestigen van boeken
//    @PostMapping("/vlucht")
//    public void confirmBooking(){}

}
