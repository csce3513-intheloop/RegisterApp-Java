package edu.uark.registerapp.commands;

import java.util.List;

import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Product;

public interface ResultCommandInterface<T> {
	T execute();
}
