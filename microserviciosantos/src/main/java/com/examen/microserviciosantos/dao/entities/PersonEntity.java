package com.examen.microserviciosantos.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class PersonEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7076515137731075412L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPerson;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastName;

    private Date age;

    public Integer getIdPerson() {
	return idPerson;
    }

    public void setIdPerson(final Integer idPerson) {
	this.idPerson = idPerson;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(final String lastName) {
	this.lastName = lastName;
    }

    public Date getAge() {
	return age;
    }

    public void setAge(final Date age) {
	this.age = age;
    }

}
