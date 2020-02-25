package edu.uark.registerapp.models.api;

import org.apache.commons.lang3.StringUtils;

public class EmployeeSignIn{
    private String password;
    private String employeeId;

    public EmployeeSignIn(){
        this.password = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
    }

    public String getEmployeeId() {
		return this.employeeId;
	}
	
    public String getPassword() {
		return this.password;
	}
	
}