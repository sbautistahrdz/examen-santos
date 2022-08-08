package com.examen.microserviciosantos.rest.dto;

import java.util.Date;
import java.util.Objects;

public class PersonRestInDto {

    private String name;

    private String lastName;

    private Date age;

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

    @Override
    public int hashCode() {
	return Objects.hash(age, lastName, name);
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof PersonRestInDto)) {
	    return false;
	}
	final PersonRestInDto other = (PersonRestInDto) obj;
	return Objects.equals(age, other.age) && Objects.equals(lastName, other.lastName)
		&& Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
	final StringBuilder builder = new StringBuilder();
	builder.append("PersonRestInDto [name=").append(name).append(", lastName=").append(lastName).append(", age=")
		.append(age).append("]");
	return builder.toString();
    }

}
