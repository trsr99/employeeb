package employeeb.service;

import java.util.List;

import employeeb.model.Mapemployee;

public interface MapemployeeService {
	public void add(Mapemployee mapemployee);
	public void update(Mapemployee mapemployee);
	public void delete(int rid);
	public Mapemployee getMapemployee(int rid);
	@SuppressWarnings("rawtypes")
	public List getAllMapemployee(); 
}
