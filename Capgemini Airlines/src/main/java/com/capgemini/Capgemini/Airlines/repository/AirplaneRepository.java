package com.capgemini.Capgemini.Airlines.repository;

import com.capgemini.Capgemini.Airlines.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {

}
