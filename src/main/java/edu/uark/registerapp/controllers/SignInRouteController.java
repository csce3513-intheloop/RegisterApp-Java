package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {
	//-- TODO: Route for initial page load 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam final Map<String, String> queryParameters) {
		
		EmployeeSignIn employee = new EmployeeSignIn();
		employee.setEmployeeId(queryParameters.get("id"));
		employee.setPassword(queryParameters.get("password"));

		ModelMap model = new ModelMap(ViewNames.EMPLOYEE_DETAIL.getViewName(), queryParameters);
		return (new ModelAndView(ViewNames.SIGN_IN.getViewName())).addObject(ViewModelNames.SIGN_IN.getValue());	
	}

	// TODO: Define an object that will represent the sign in request and add it as a parameter here
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(EmployeeSignIn signIn, HttpServletRequest request)
	{  
	// TODO: Use the credentials provided in the request body
    //  and the "id" property of the (HttpServletRequest)request.getSession() variable
    //  to sign in the user
		final ModelAndView modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());

      try {
         modelAndView.addObject(ViewModelNames.EMPLOYEE_DETAIL.getValue(),
         this.employeeQuery.setEmployeeId(UUID.fromString(request.getRequestedSessionId())));

      } catch(final Exception e){}

      return new ModelAndView(
         REDIRECT_PREPEND.concat(
            ViewNames.MAIN_MENU.getRoute()));

  	 }
  	 @Autowired      
  	private EmployeeQuery employeeQuery;
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery; 
	private EmployeeEntity employeeEntity;
}