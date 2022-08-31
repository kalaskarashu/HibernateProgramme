package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="student")
public class Student {
	@Id
	@Column (name="Rollno")
	private int rollno;
	@Column (name="Name")
	private String name;
	@Column (name="Division")
	private String division;
	@Column (name="Marks")
	private double marks;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", division=" + division + ", marks=" + marks + "]";
	}
	
	
	
}
