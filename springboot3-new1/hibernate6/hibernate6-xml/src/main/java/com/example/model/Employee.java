package com.example.model;

public class Employee {
	
	private String name;  
	private int id;  
	private double sal;  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSal() {  
	    return sal;  
	}  
	public void setSal(double sal) {  
	    this.sal = sal;  
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", sal=" + sal + "]";
	}  
}
