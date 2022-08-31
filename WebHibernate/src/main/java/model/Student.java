package model;

public class Student {
	private int rollno;
	private String name;
	private double marks;
	private String div;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name,  double marks, String div,int rollno) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.div = div;
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
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", div=" + div + "]";
	}
	

}
