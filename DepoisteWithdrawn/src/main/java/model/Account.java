package model;

public class Account {
int id;
double amount;
public Account() {
	// TODO Auto-generated constructor stub
}
public Account(int id, double amount) {
	super();
	this.id = id;
	this.amount = amount;
}
public void setDeposite(double amt) {
	this.amount=this.amount+amt;
	
}
public double getAmount() {
	
	return this.amount;
}
public void setAmount(double bal) {
	this.amount=bal;
	
}
public void setWithdrawn(double amt) {
	this.amount=this.amount-amt;
	
}





}
