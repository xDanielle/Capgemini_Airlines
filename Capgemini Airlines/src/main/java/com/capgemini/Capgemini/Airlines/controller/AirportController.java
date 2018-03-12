package com.capgemini.Capgemini.Airlines.controller;

import com.capgemini.Capgemini.Airlines.model.Airport;
import com.capgemini.Capgemini.Airlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/airports/")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;


    // Get all Airports
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Iterable<Airport> index() {
        return airportRepository.findAll();
    }

    // Add Airport
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody Airport airportToSave) {
        airportRepository.save(airportToSave);
    }

    // Delete Airport
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteAirport(@PathVariable long id) {
        airportRepository.delete(id);
    }



}
