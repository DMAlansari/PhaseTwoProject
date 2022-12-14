package com.MyFirst.SpringProject;

public class Engineer {
	
	private Integer id;
	private String  name;
	private String  skills;

	
public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

@Override
	public String toString() {
		return "Engineer [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}

public Engineer() {
		super();
	}

public Engineer(Integer id, String name, String skills) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
	}

public void workForWages() {
System.out.println("work for wages");
System.out.println("Hello there I am an engineer and my details are: ");
System.out.println(this); // prints the object in toString method
}

}
