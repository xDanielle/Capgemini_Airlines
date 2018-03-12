package com.capgemini.Capgemini.Airlines.service;

import com.capgemini.Capgemini.Airlines.model.Airport;
import com.capgemini.Capgemini.Airlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @PostConstruct
    public void init(){
        Airport airport1 = new Airport();


        this.airportRepository.save(airport1);
    }

}
