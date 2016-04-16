package de.girlsday.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import de.girlsday.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	public User findByName(String name); 
}