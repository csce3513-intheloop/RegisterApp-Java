package edu.uark.registerapp.commands.employees;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.ConflictException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;

import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class EmployeeCreateCommand implements ResultCommandInterface<Employee> {
    @Override
    public Employee execute() {
        this.validateProperties();

        final EmployeeEntity createdEmployeeEntity = this.createEmployeeEntity();

        // Synchronize information generated by the database upon INSERT.
        this.apiEmployee.setId(createdEmployeeEntity.getId());
        this.apiEmployee.setCreatedOn(createdEmployeeEntity.getCreatedOn());

        return this.apiEmployee;
    }

    // Helper methods
    private void validateProperties() {
<<<<<<< HEAD
        if (this.apiEmployee.validate()) { //mitch 
            throw new UnprocessableEntityException("lookupcode");
=======
        if (StringUtils.isBlank(this.apiEmployee.getFirstName())) {
            throw new UnprocessableEntityException("firstname");
        }
        if (StringUtils.isBlank(this.apiEmployee.getLastName())) {
            throw new UnprocessableEntityException("lastname");
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490
        }
    }

    @Transactional
    private EmployeeEntity createEmployeeEntity() {
        final Optional<EmployeeEntity> queriedEmployeeEntity = this.employeeRepository
<<<<<<< HEAD
                .existsByEmployeeId(apiEmployee.getEmployeeId());
=======
                .findById(this.apiEmployee.getId());
>>>>>>> 8e8c10c87b0c55be0176617c9b270ed2271bf490

        if (queriedEmployeeEntity.isPresent()) {
            // Lookupcode already defined for another employee.
            throw new ConflictException("Id");
        }

        return this.employeeRepository.save(new EmployeeEntity(apiEmployee));
    }

    // Properties
    private Employee apiEmployee;

    public Employee getApiEmployee() {
        return this.apiEmployee;
    }

    public EmployeeCreateCommand setApiemployee(final Employee apiEmployee) {
        this.apiEmployee = apiEmployee;
        return this;
    }

    @Autowired
    private EmployeeRepository employeeRepository;
}
