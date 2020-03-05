package edu.uark.registerapp.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@RestController
@RequestMapping(value = "/api")
public class SignInRestController extends BaseRestController {
	@RequestMapping(value="/signOut", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse removeActiveUser(
		final HttpServletRequest request) {
			//this.ActiveUserDeleteCommend(request.getSession().getId()); // <removeActiveUser> --> need to change using ActiveUserDeleteCommend.java
						
			final Optional<EmployeeEntity> employeeEntity =
			this.employeeRepository.findById(this.employeeId);
		if (!employeeEntity.isPresent()) { // No record with the associated record ID exists in the database.
			throw new NotFoundException("EmployeeId");
		}

		this.employeeRepository.delete(employeeEntity.get());
		// TODO: Sign out the user associated with request.getSession().getId()

		return (new ApiResponse())
			.setRedirectUrl(ViewNames.SIGN_IN.getRoute());
	}
	// Properties
	private UUID employeeId;
	public UUID getemployeeId() {
		return this.employeeId;
	}
	public SignInRestController setemployeeId(final UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	@Autowired
	private EmployeeRepository employeeRepository;
}
