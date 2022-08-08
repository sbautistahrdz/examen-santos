package com.examen.microserviciosantos.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.microserviciosantos.rest.dto.PersonRestInDto;
import com.examen.microserviciosantos.rest.dto.PersonRestOutDto;
import com.examen.microserviciosantos.services.PersonService;
import com.examen.microserviciosantos.services.dto.PersonServiceInDto;
import com.examen.microserviciosantos.services.dto.PersonServiceOutDto;

@RestController
@RequestMapping(value = "public")
public class PersonRestController {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    private PersonRestOutDto addANewPerson(@RequestBody final PersonRestInDto personRestInDto) {

	final PersonRestOutDto personRestOutDto = new PersonRestOutDto();

	final PersonServiceInDto personServiceInDto = new PersonServiceInDto();
	personServiceInDto.setName(personRestInDto.getName());
	personServiceInDto.setLastName(personRestInDto.getLastName());
	personServiceInDto.setAge(personRestInDto.getAge());

	final PersonServiceOutDto newPersonAdded = personService.addANewPerson(personServiceInDto);

	personRestOutDto.setIdPerson(newPersonAdded.getIdPerson());

	return personRestOutDto;
    }

    @GetMapping("/person/{idPerson}")
    private PersonRestOutDto getPersonById(@PathVariable("idPerson") final Integer idPerson) {

	final PersonRestOutDto personRestOutDto = new PersonRestOutDto();

	final PersonServiceOutDto personServiceOutDto = personService.getPersonById(idPerson);

	personRestOutDto.setIdPerson(personServiceOutDto.getIdPerson());
	personRestOutDto.setName(personServiceOutDto.getName());
	personRestOutDto.setLastName(personServiceOutDto.getLastName());
	personRestOutDto.setAge(personServiceOutDto.getAge());

	return personRestOutDto;
    }

    @PutMapping("/person/{idPerson}")
    private void updatePersonById(@PathVariable("idPerson") final Integer idPerson,
	    @RequestBody final PersonRestInDto personRestInDto) {

	final PersonServiceInDto personServiceInDto = new PersonServiceInDto();
	personServiceInDto.setName(personRestInDto.getName());
	personServiceInDto.setLastName(personRestInDto.getLastName());
	personServiceInDto.setAge(personRestInDto.getAge());

	personService.updatePersonById(idPerson, personServiceInDto);
    }

}
