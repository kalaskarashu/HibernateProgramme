package model;

public class Student {
	private int rollno;
	private String name;
	private String div;
	private double marks;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String name, String div, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.div = div;
		this.marks = marks;
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

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", div=" + div + ", marks=" + marks + "]";
	}

}
