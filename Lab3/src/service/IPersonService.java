package service;

import java.util.ArrayList;

import model.Person;


public interface IPersonService {
	public ArrayList<Person> allPerson();
	public PersonService createPerson(String name);
	public Integer howManyPeopleExist();
}
