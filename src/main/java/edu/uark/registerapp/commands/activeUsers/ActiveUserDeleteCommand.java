package edu.uark.registerapp.commands.activeUsers;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;
import edu.uark.registerapp.models.api.Employee;

@Service
public class ActiveUserDeleteCommand implements VoidCommandInterface{
    @Transactional
	@Override
	public void execute() {
		final Optional<ActiveUserEntity> ActiveUserEntity =
			this.ActiveUserRepository.findBySessionKey(this.sessionKey);
		if (!ActiveUserEntity.isPresent()) { // No record with the associated record ID exists in the database.
			throw new NotFoundException("ActiveUser");
		}

		this.ActiveUserRepository.delete(ActiveUserEntity.get());
    }
    public boolean FirstNamecheck(){
        if(Employee.getFirstName() != ""){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean LastNamecheck(){
        if(Employee.getLastName() != ""){
            return true;
        }
        else{
            return false;
        }
    }
    private String sessionKey;
    public String getSessionKey() {
		return this.sessionKey;
	}

    public ActiveUserDeleteCommand setSessionKey(final String sessionKey) {
		this.sessionKey = sessionKey;
		return this;
    }
    

    @Autowired
    private ActiveUserRepository ActiveUserRepository;
    private Employee Employee;
}