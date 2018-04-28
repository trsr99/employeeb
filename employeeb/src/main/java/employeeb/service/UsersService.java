package employeeb.service;

import java.util.List;

import employeeb.model.Users;

public interface UsersService {
	public void add(Users users);
	public void update(Users users);
	public void delete(String rid);
	public Users getUsers(String rid);
	@SuppressWarnings("rawtypes")
	public List getAllUsers(); 
}
