package edu.uark.registerapp.commands.employees;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
//import org.springframework.data.repository.CrudRepository;

//import edu.uark.registerapp.commands.ResultCommandInterface;
//import edu.uark.registerapp.commands.VoidCommandInterface;
//import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;

//import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;
//import edu.uark.registerapp.commands.employees.helpers.EmployeeHelper;




public class EmployeeSignInCommand{
    // implements VoidCommandInterface{
    private EmployeeSignIn employeeSignIn;
    private String sessionKey;
    private EmployeeRepository EmployeeRepository;
    private EmployeeEntity EmployeeEntity;
    private UUID employeeId;
    private ActiveUserRepository ActiveUserRepository;
    private ActiveUserEntity ActiveUserEntity;
    
    /*public EmployeeSignInCommand execute() {
        final Optional<EmployeeEntity> EmployeeEntity = this.EmployeeRepository.findByEmployeeId(this.employeeId);
        final Optional<ActiveUserEntity> ActiveUserEntity = this.ActiveUserRepository.findBySessionKey(this.sessionKey);
    
        
    }*/

    public boolean IDcheck(){
        if(employeeSignIn.getEmployeeId() != ""){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean Passwordcheck(){
        if(employeeSignIn.getPassword() != ""){
            return true;
        }
        else{
            return false;
        }
    }
     
    private boolean queryID(){
        if(EmployeeRepository.existsByEmployeeId(employeeSignIn.getEmployeeId())) {
            if(Arrays.equals(edu.uark.registerapp.commands.employees.helpers.EmployeeHelper
                    .hashPassword(employeeSignIn.getPassword()), EmployeeEntity.getPassword())) {
                        return true;
            }
            else{
                return false;
            }
        } 
        else{
            return false;
        }
    }
    private UUID productId;
    @Transactional
	private ActiveUserEntity createActiveuserEntity() {
		final Optional<ActiveUserEntity> queriedActiveUserEntity =
			this.ActiveUserRepository.findByEmployeeId(this.productId);
		if (queriedActiveUserEntity.isPresent()) {
            ActiveUserEntity.setSessionKey(this.sessionKey);
            return this.ActiveUserRepository.save(this.ActiveUserEntity);
        }
        else{
            ActiveUserEntity = new ActiveUserEntity();
            ActiveUserEntity.setSessionKey(this.sessionKey);
            return this.ActiveUserRepository.save(ActiveUserEntity);
        }

    }
    
    
}
