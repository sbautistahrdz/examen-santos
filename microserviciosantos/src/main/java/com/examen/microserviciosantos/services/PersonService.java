package com.examen.microserviciosantos.services;

import com.examen.microserviciosantos.services.dto.PersonServiceInDto;
import com.examen.microserviciosantos.services.dto.PersonServiceOutDto;

public interface PersonService {

    public PersonServiceOutDto addANewPerson(PersonServiceInDto personServiceInDto);

    public PersonServiceOutDto getPersonById(Integer idPerson);

    public void updatePersonById(Integer idPerson, PersonServiceInDto personServiceInDto);

}
