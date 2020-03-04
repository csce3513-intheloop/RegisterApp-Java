package edu.uark.registerapp.commands;

import edu.uark.registerapp.models.api.Employee;

public interface ResultCommandInterface<T> {
	T execute();
}
