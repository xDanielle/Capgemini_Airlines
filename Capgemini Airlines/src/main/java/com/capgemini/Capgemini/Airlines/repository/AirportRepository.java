package com.capgemini.Capgemini.Airlines.repository;

import com.capgemini.Capgemini.Airlines.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

}
