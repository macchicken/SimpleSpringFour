package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.Person;

/**
 * @author Barry
 * An in-memory implementation of the Dao
 *
 */
public class PersonDaoMemImpl implements PersonDao {

	private Map<String,Person> plist;

	public PersonDaoMemImpl(){
		plist = new HashMap<String,Person>();
	}

	@Override
	public void addPerson(Person p) {
		String newId= UUID.randomUUID().toString().replaceAll("-", "");
		p.setId(newId);
		plist.put(p.getId(),p);
	}

	@Override
	public void deletePerson(String personId) {
		plist.remove(personId);
	}

	@Override
	public List<Person> getAllPerson() {
		ArrayList<Person> result=new ArrayList<Person>();
		for (Person p:plist.values()){
			result.add(p);
		}
		return result;
	}

	@Override
	public Person getPersonById(String personId) {
		return plist.get(personId);
	}

	@Override
	public void updatePerson(Person p) {
		if (plist.containsKey(p.getId())) {
			plist.put(p.getId(), p);
		}
	}

}
