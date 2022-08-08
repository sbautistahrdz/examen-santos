package com.examen.microserviciosantos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.microserviciosantos.dao.entities.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

}
