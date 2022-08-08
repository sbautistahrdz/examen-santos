package com.examen.microserviciosantos.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.examen.microserviciosantos.dao.PersonRepository;
import com.examen.microserviciosantos.dao.entities.PersonEntity;
import com.examen.microserviciosantos.services.dto.PersonServiceInDto;
import com.examen.microserviciosantos.services.dto.PersonServiceOutDto;
import com.examen.microserviciosantos.services.impl.PersonServiceImpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    private final String NAME = "Santos";
    private final String LAST_NAME = "Bautista";
    private final Integer YEAR = 1996;
    private final Integer MONTH = 9;
    private final Integer DAY = 9;
    private final Integer ID_PERSON = 1;

    @InjectMocks
    PersonService personService = new PersonServiceImpl();

    @Mock
    PersonRepository personRepository;

    @Test
    void addANewPerson() {

	final PersonServiceInDto personServiceInDto = createPersonServiceInDto();

	final PersonEntity savePersonEntity = createPersonEntity();
	when(personRepository.save(any(PersonEntity.class))).thenReturn(savePersonEntity);

	final PersonServiceOutDto personServiceOutDto = personService.addANewPerson(personServiceInDto);

	assertNotNull(personServiceInDto);
	assertNotNull(personServiceOutDto.getIdPerson());
	assertEquals(personServiceOutDto.getIdPerson(), ID_PERSON);
	assertEquals(personServiceInDto.getName(), NAME);
	assertEquals(personServiceInDto.getLastName(), LAST_NAME);

	final Date age = new Date(YEAR, MONTH, DAY);
	assertEquals(personServiceInDto.getAge(), age);

    }

    @Test
    public void getPersonById() {

	when(personRepository.findById(ID_PERSON)).thenReturn(Optional.of(createPersonEntity()));

	final PersonServiceOutDto personServiceOutDto = personService.getPersonById(ID_PERSON);

	assertNotNull(personServiceOutDto);
	assertEquals(personServiceOutDto.getIdPerson(), ID_PERSON);
	assertEquals(personServiceOutDto.getName(), NAME);
	assertEquals(personServiceOutDto.getLastName(), LAST_NAME);

	final Date age = new Date(YEAR, MONTH, DAY);
	assertEquals(personServiceOutDto.getAge(), age);

	verify(personRepository, times(1)).findById(anyInt());

    }

    @Test
    public void updatePersonById() {

	final PersonServiceInDto personServiceInDto = createPersonServiceInDto();

	when(personRepository.findById(ID_PERSON)).thenReturn(Optional.of(createPersonEntity()));
	when(personRepository.save(any(PersonEntity.class))).thenReturn(createPersonEntity());

	personService.updatePersonById(ID_PERSON, personServiceInDto);

	assertNotNull(personServiceInDto);

    }

    private PersonEntity createPersonEntity() {

	final PersonEntity personEntity = new PersonEntity();

	personEntity.setIdPerson(1);
	personEntity.setName(NAME);
	personEntity.setLastName(LAST_NAME);

	final Date age = new Date(YEAR, MONTH, DAY);
	personEntity.setAge(age);

	return personEntity;
    }

    private PersonServiceInDto createPersonServiceInDto() {

	final PersonServiceInDto personServiceInDto = new PersonServiceInDto();

	personServiceInDto.setName(NAME);
	personServiceInDto.setLastName(LAST_NAME);

	final Date age = new Date(YEAR, MONTH, DAY);
	personServiceInDto.setAge(age);

	return personServiceInDto;
    }

}
