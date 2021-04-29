package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

	@Autowired 
	IEmployeService es; 

	@Test
	public void testAddEmploye() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Employe e = new Employe(null, null, null, false, null); 
		Employe employeAdded = es.addEmploye(e); 
		assertEquals(e.getPrenom(), employeAdded.getPrenom());
	}
	
	@Test
	public void testModifyEmploye() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Employe e = new Employe(null, null, null, false, null); 
		Employe employeUpdated  = es.updateEmploye(e); 
		assertEquals(e.getPrenom(), employeUpdated.getPrenom());
	}

	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listUsers = es.retrieveAllEmploye(); 
		// if there are 5 users in DB : 
		assertEquals(5, listUsers.size());
	}

	@Test
	public void testRetrieveEmploye() {
		Employe employeRetrieved = es.retrieveEmploye("1"); 
		assertEquals(1L, employeRetrieved.getId());
	}

}





