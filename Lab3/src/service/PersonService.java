package service;

import java.util.ArrayList;

import model.Person;

/*
 * PersonService can manage a person
 * includes reference to Person
 * 
 * We have creator to create person
 * All new person is added to ArayList
 */
public class PersonService implements IPersonService {

	private Person person;
	private ArrayList<Person> allPerson = new ArrayList<Person>();
	
	@Override
	public PersonService createPerson(String name) {
		setPerson(new Person());
		getPerson().setName(name);
		allPerson.add(getPerson());
		return this;
	}
	
	@Override
	public String toString() {
		for (Person person : allPerson) {
			System.out.println("Person name:" + person.getName());
		}
		return super.toString();
	}

	@Override
	public ArrayList<Person> allPerson() {
		return allPerson;
	}

	@Override
	public Integer howManyPeopleExist() {
		return allPerson.size();
	}
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}




}
