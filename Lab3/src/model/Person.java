package model;

/*
 * Person "entity"
 * containt information about: name
 */
public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name "+ getName() ;
	}
}
