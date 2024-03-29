package de.girlsday.api;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.girlsday.StringForSwagger;
import de.girlsday.dal.UserRepository;
import de.girlsday.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class UserController extends StringForSwagger {

	@Autowired
	UserRepository userRepository;

	 @ApiOperation(value = loginDescription, nickname = loginTitel)
	    @RequestMapping(method = RequestMethod.GET, path=loginPath, produces = "application/json")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = nameParam, value = loginParamDescription, required = true, dataType = "string", paramType = "query", defaultValue="Ina")
	      })
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = User.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public User greeting(@RequestParam(value = nameParam) String name) {
		User user = new User();
		user.setName(name);
		verifyUser(user);
		User result = userRepository.save(user);
		return result ;
	}

	private void verifyUser(User user) {
		if(null != userRepository.findByName(user.getName())){
			throw new BadRequestException("User Already Exist!");
		}
		
	}
}
