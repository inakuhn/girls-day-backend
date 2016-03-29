package de.girlsday.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}