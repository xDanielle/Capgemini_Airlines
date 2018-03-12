package com.capgemini.Capgemini.Airlines.service;


import com.capgemini.Capgemini.Airlines.model.Airplane;
import com.capgemini.Capgemini.Airlines.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @PostConstruct
    public void init(){
        Airplane plane1 = new Airplane();
        plane1.setNamePlane("Boeing 737");
        plane1.setCurrentFuel(10000);
        plane1.setLocationPlane("Capgemini Airport");

        Airplane plane2 = new Airplane();
        plane2.setNamePlane("Jetsetter");
        plane2.setCurrentFuel(10);
        plane2.setLocationPlane("Malta Airport");



        this.airplaneRepository.save(plane1);
        this.airplaneRepository.save(plane2);

    }


}

