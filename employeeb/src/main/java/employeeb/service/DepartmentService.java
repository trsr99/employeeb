package employeeb.service;

import java.util.List;

import employeeb.model.Department;

public interface DepartmentService {
	public void add(Department department);
	public void update(Department department);
	public void delete(int rid);
	public Department getDepartment(int rid);
	@SuppressWarnings("rawtypes")
	public List getAllDepartment(); 
}
