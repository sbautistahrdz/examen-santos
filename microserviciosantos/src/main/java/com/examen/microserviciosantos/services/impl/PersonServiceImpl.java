package com.examen.microserviciosantos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.microserviciosantos.dao.PersonRepository;
import com.examen.microserviciosantos.dao.entities.PersonEntity;
import com.examen.microserviciosantos.services.PersonService;
import com.examen.microserviciosantos.services.dto.PersonServiceInDto;
import com.examen.microserviciosantos.services.dto.PersonServiceOutDto;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonServiceOutDto addANewPerson(final PersonServiceInDto personServiceInDto) {

	final PersonServiceOutDto personServiceOutDto = new PersonServiceOutDto();

	final PersonEntity personEntity = new PersonEntity();
	personEntity.setName(personServiceInDto.getName());
	personEntity.setLastName(personServiceInDto.getLastName());
	personEntity.setAge(personServiceInDto.getAge());

	try {

	    final PersonEntity newPersonAdded = personRepository.save(personEntity);

	    personServiceOutDto.setIdPerson(newPersonAdded.getIdPerson());

	} catch (final Exception e) {

	    e.printStackTrace();
	}

	return personServiceOutDto;
    }

    @Override
    public PersonServiceOutDto getPersonById(final Integer idPerson) {

	final PersonServiceOutDto personServiceOutDto = new PersonServiceOutDto();

	PersonEntity personEntity = null;

	try {

	    personEntity = personRepository.findById(idPerson).get();

	    personServiceOutDto.setIdPerson(personEntity.getIdPerson());
	    personServiceOutDto.setName(personEntity.getName());
	    personServiceOutDto.setLastName(personEntity.getLastName());
	    personServiceOutDto.setAge(personEntity.getAge());

	} catch (final Exception e) {

	    e.printStackTrace();
	}

	return personServiceOutDto;
    }

    @Override
    public void updatePersonById(final Integer idPerson, final PersonServiceInDto personServiceInDto) {

	personRepository.findById(idPerson).map(personEntity -> {
	    personEntity.setName(personServiceInDto.getName());
	    personEntity.setLastName(personServiceInDto.getLastName());
	    personEntity.setAge(personServiceInDto.getAge());

	    return personRepository.save(personEntity);
	});

    }

}
