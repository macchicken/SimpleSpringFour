package dao;

import java.util.List;
import model.Person;

public interface PersonDao {
	public List<Person> getAllPerson();
	public void addPerson(Person p);
	public Person getPersonById(String personId);
	public void updatePerson(Person p);
	public void deletePerson(String personId);	
}
