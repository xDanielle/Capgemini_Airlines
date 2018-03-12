package com.capgemini.Capgemini.Airlines.controller;

import com.capgemini.Capgemini.Airlines.model.Airplane;
import com.capgemini.Capgemini.Airlines.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/planes/")
public class AirplaneController {

    @Autowired
    private AirplaneRepository airplaneRepository;


    //RequestMappings
    //Get all planes
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Iterable<Airplane> index() {
        return airplaneRepository.findAll();
    }

    // Save a plane in database
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save (@RequestBody Airplane airplaneToSave){
        airplaneRepository.save(airplaneToSave);
    }

    // Delete a plane
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
        public void deleteAirplane(@PathVariable long id){
            airplaneRepository.delete(id);
    }

    // Add fuel
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void addFuel(@PathVariable long id, @RequestBody Airplane airplaneToFuel) {
        // ophalen airplane met id en dan saven
        Airplane p = this.airplaneRepository.findOne(id);
        p.setCurrentFuel(airplaneToFuel.getCurrentFuel());
        airplaneRepository.save(p);
    }

    // Fly little plane
    @RequestMapping(value = "flight/{id}", method = RequestMethod.PUT)
    public void flyLittlePlane(@PathVariable long id, @RequestBody Airplane airplaneToFly) {
        // ophalen airplane met id en dan saven na vlucht
        Airplane plane = this.airplaneRepository.findOne(id);
        plane.setCurrentFuel(airplaneToFly.getCurrentFuel());
        airplaneRepository.save(plane);
    }

    // Edit & Find

}
