package edu.uark.registerapp.models.api;

import org.apache.commons.lang3.StringUtils;

public class EmployeeSignIn{
    private String password;
    private String employeeId;

<<<<<<< HEAD
	public EmployeeSignIn(){
=======
  public EmployeeSignIn(){
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490
		this.password = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}