package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp")

public class Employee {
	@Id
	@Column (name="ID")
	private int empid;
	
private String empname;
@Embedded
private Address add;
public Employee() {
	// TODO Auto-generated constructor stub
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public Address getAdd() {
	return add;
}
public void setAdd(Address add) {
	this.add = add;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", add=" + add + "]";
}

}
