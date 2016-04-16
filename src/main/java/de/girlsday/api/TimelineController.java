package de.girlsday.api;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import de.girlsday.StringForSwagger;
import de.girlsday.dal.TimelineRepository;
import de.girlsday.dal.UserRepository;
import de.girlsday.model.TimelineItem;
import de.girlsday.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TimelineController extends StringForSwagger {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TimelineRepository timelineRepository;
	@Autowired
	private HttpServletRequest request;

	@ApiOperation(value = timelineGetDescription, nickname = timelineGetTitel)
	@RequestMapping(method = RequestMethod.GET, path = timelineGetPath, produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = nameParam, value = timelineParamGetDescription, required = false, dataType = "string", paramType = "query", defaultValue = "Ina") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public List<TimelineItem> getTimelineItems(@RequestParam(value = nameParam) String name) {
		List<TimelineItem> result = new LinkedList<>();
		verifyUser(name);
		User user = userRepository.findByName(name);
		result = timelineRepository.findByUser(user);
		return result;

	}

	@ApiOperation(value = timelinePostDescription, nickname = timelinePostTitel)
	@RequestMapping(method = RequestMethod.POST, path = timelinePostPath,produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = nameParam, value = timelineParamPostDescription, required = false, dataType = "string", paramType = "query", defaultValue = "Ina") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public TimelineItem postTimelineItems(@RequestParam(value = nameParam, required = true) String name,
			@RequestParam(value = timelineFileParam) MultipartFile photo,
			@RequestParam(value = timelineMessageParam) String message) {
		TimelineItem timelineItem = new TimelineItem();
		String filePath = "C:\\Temp\\girlsdaypicture\\";
		String uid = null;
		try {
			uid = UUID.randomUUID().toString();
			photo.transferTo(new File(filePath+uid+".png"));
			timelineItem.setMessage(message);
			timelineItem.setPictureUID(uid);
			timelineItem.setUser(userRepository.findByName(name));
			timelineRepository.save(timelineItem);

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return timelineItem;

	}

	private void verifyUser(String name) {
		if (null == userRepository.findByName(name)) {
			throw new BadRequestException("User do not Exist!");
		}

	}

}
