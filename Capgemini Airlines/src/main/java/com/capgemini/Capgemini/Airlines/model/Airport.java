package com.capgemini.Capgemini.Airlines.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameAirport;
    private String locationAirport;

    //Relationship one Airport has many Airplanes
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "airport")
    private List<Airplane> airplane;


    //constructors
    public Airport(){}



    //getters & setters
    public long getId() {
        return id;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public String getLocationAirport() {
        return locationAirport;
    }

    public void setLocationAirport(String locationAirport) {
        this.locationAirport = locationAirport;
    }
}
