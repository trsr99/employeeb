package employeeb.dao;

import java.util.List;

import employeeb.model.Employee;

public interface EmployeeDao {
	public void add(Employee employee);
	public void update(Employee employee);
	public void delete(int rid);
	public Employee getEmployee(int rid);
	@SuppressWarnings("rawtypes")
	public List getAllEmployee(); 
}
