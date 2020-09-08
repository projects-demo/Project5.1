package com.spring.model;

public class EmployeeDetails {
	private int id;
	private String name;

	public EmployeeDetails() {
		System.out.println("default cons");
	}

	public EmployeeDetails(int id) {
		this.id = id;
	}

	public EmployeeDetails(String name) {
		this.name = name;
	}

	public EmployeeDetails(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public EmployeeDetails(String name, int id) {
		this.id = id;
		this.name = name;
	}

	void show() {
		System.out.println(id + " " + name);
	}

}