package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@PrimaryKeyJoinColumn(name = "pid")
public class Account {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private double amount;
	private String bname;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public void setDebit(double amt) {
		if (amt > this.amount) {
			throw new InsuffientBalanceException();
		} else {
			this.amount = this.amount - amt;
		}
	}

	public void setCredit(double amt) {
		this.amount = this.amount + amt;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + ", bname=" + bname + "]";
	}

}
