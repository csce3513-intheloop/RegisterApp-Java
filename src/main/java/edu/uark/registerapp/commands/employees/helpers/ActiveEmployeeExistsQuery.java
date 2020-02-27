package edu.uark.registerapp.commands.employees.helpers;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

public class  ActiveEmployeeExistsQuery {
    /*@Override
    public void execute() {
        final Optional<EmployeeEntity> employeeEntity =
            this.employeeRepository.findByEmployeeId(this.employeeId);
        if(employeeRepository.existsByIsActive(true)) { 
        } else {
            throw new NotFoundException("Employee");
        }
    
    }*/
    
    public boolean check(){
        
		if(employeeRepository.existsByIsActive(true)) {
            return true; 
        } else {
            throw new NotFoundException("Employee");
        }
    }
    //private int employeeId;
    @Autowired
	private EmployeeRepository employeeRepository;
}