package de.girlsday.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.girlsday.dal.UserRepository;
import de.girlsday.model.User;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/greeting")
	@ResponseBody
	public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setName(name);
		User result = userRepository.save(user);
		return result ;
	}
}
