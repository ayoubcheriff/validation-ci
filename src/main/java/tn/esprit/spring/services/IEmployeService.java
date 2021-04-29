package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {

	public List<Employe> retrieveAllEmploye();
	public Employe addUser(Employe e);
	public Employe updateEmploye(Employe e);
	public void deleteEmploye(String id);
	public Employe retrieveEmploye(String id);
	public Employe addEmploye(Employe e);
	
	
}
