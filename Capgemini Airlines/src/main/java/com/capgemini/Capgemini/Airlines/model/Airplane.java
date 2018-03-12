package com.capgemini.Capgemini.Airlines.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Airplane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String namePlane;
    private int currentFuel;
    private String locationPlane;

    // Relationship with Airport
    @ManyToOne
    private Airport airport;




    // constructors
    public Airplane() { }



    //getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getLocationPlane() {
        return locationPlane;
    }

    public void setLocationPlane(String locationPlane) {
        this.locationPlane = locationPlane;
    }
}
