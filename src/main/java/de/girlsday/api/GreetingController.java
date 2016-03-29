package de.girlsday.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.girlsday.dal.UserRepository;
import de.girlsday.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	UserRepository userRepository;

	 @ApiOperation(value = "getGreeting", nickname = "getGreeting")
	    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = User.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setName(name);
		User result = userRepository.save(user);
		return result ;
	}
}
