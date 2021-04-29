package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository EmployeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
 
	@Override
	public List<Employe> retrieveAllEmploye() {
		l.info("In  retrieveAllemployes : "); 
		List<Employe> employes = (List<Employe>) EmployeRepository.findAll();  
		for (Employe employe : employes) {
			l.debug("employe +++ : " + employe);
		}
		l.info("Out of retrieveAllemployes."); 
		return employes;
	}

	@Override
	public Employe addUser(Employe e) {
		l.info("In  addUser : " + e); 
		Employe userSaved = EmployeRepository.save(e);
		l.info("Out of  addUser. "); 
		return userSaved; 
	}

	@Override 
	public Employe updateEmploye(Employe e) {
		return EmployeRepository.save(e);
	}

	@Override
	public void deleteEmploye(String id) {
		EmployeRepository.deleteById((int) Long.parseLong(id));
	}

	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveEmploye id = " + id);
		// Optional retrun type - Java 8 (susceptible de retourner des valeurs «vides» et pas null)
		Employe e =  EmployeRepository.findById((int) Long.parseLong(id)).orElse(null);
		//User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("user returned : " + e);
		return e; 
	}

	@Override
	public Employe addEmploye(Employe e) {
		// TODO Auto-generated method stub
		return null;
	}

}
