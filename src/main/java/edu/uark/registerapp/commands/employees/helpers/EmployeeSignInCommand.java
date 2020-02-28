package edu.uark.registerapp.commands.employees.helpers;

import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.EmployeeSignIn;

public class EmployeeSignInCommand {
    private EmployeeSignIn employeeSignIn;
    private int session_key;
    //private Employee employee;

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
}