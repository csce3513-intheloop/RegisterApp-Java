package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;
<<<<<<< HEAD
=======
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {
<<<<<<< HEAD
	// TODO: Route for initial page load 
	public ModelAndView start() {
		return (new ModelAndView(ViewNames.signIn.getViewName())).addObject(ViewModelNames.EMPLOYEE.getValue(),
			   (new Employee()).setEmployeeId(StringUtils.EMPTY).setCount(0));

	}
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(
		// TODO: Define an object that will represent the sign in request and add it as a parameter here

		HttpServletRequest request
=======
	//-- TODO: Route for initial page load 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start() {
		return (new ModelAndView(ViewNames.SIGN_IN.getViewName())).addObject(ViewModelNames.SIGN_IN.getValue());	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(
		// TODO: Define an object that will represent the sign in request and add it as a parameter here
		EmployeeSignIn signIn, HttpServletRequest request
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490
	) {  
		final ModelAndView modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
      // TODO: Use the credentials provided in the request body
      //  and the "id" property of the (HttpServletRequest)request.getSession() variable
      //  to sign in the user
      try {
         modelAndView.addObject(ViewModelNames.EMPLOYEE_DETAIL.getValue(),
         this.employeeQuery.setEmployeeId(UUID.fromString(request.getRequestedSessionId())));

<<<<<<< HEAD
		// TODO: Use the credentials provided in the request body rawr
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user
=======
      } catch(final Exception e){}
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490

      return new ModelAndView(
         REDIRECT_PREPEND.concat(
            ViewNames.MAIN_MENU.getRoute()));

  	 }
  	 @Autowired      
  	private EmployeeQuery employeeQuery;
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery; 
	private EmployeeEntity employeeEntity;
}