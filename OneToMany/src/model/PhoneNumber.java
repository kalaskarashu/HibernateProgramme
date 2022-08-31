package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Phonenum")
public class PhoneNumber {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private long phnum;
	private long ofnum;
	
	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(long phnum, long ofnum) {
		super();
		this.phnum = phnum;
		this.ofnum = ofnum;
	}

	public long getPhnum() {
		return phnum;
	}

	public void setPhnum(long phnum) {
		this.phnum = phnum;
	}

	public long getOfnum() {
		return ofnum;
	}

	public void setOfnum(long ofnum) {
		this.ofnum = ofnum;
	}

}
