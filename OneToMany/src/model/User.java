package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="joinid")
	private List<PhoneNumber> phno;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, List<PhoneNumber> phno) {
		super();
		this.name = name;
		this.phno = phno;
	}

	public String toString() {
		return "User [name=" + name + ", phno=" + phno + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PhoneNumber> getPhno() {
		return phno;
	}

	public void setPhno(List<PhoneNumber> phno) {
		this.phno = phno;
	}

}
