package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class EmployeeQuery implements ResultCommandInterface<Employee> {
    @Override
    public Employee execute() {
        final Optional<EmployeeEntity> EmployeeEntity = this.EmployeeRepository.findById(this.employeeId);
        if (EmployeeEntity.isPresent()) {
            return new Employee(EmployeeEntity.get());
        } else {
            throw new NotFoundException("Employee");
        }
    }

    // Properties
    private UUID employeeId;

    public UUID getEmployeeId() {
        return this.employeeId;
    }

    public EmployeeQuery setEmployeeId(final UUID employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @Autowired
    private EmployeeRepository EmployeeRepository;

    // still building
}
