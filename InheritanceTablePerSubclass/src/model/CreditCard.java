package model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="CreditInfo")
@PrimaryKeyJoinColumn (name="pid")
public class CreditCard extends Payment {
private int cardno;
private String cardtype;
public CreditCard() {
	// TODO Auto-generated constructor stub
}
public int getCardno() {
	return cardno;
}
public void setCardno(int cardno) {
	this.cardno = cardno;
}
public String getCardtype() {
	return cardtype;
}
public void setCardtype(String cardtype) {
	this.cardtype = cardtype;
}
@Override
public String toString() {
	return "CreditCard [cardno=" + cardno + ", cardtype=" + cardtype + "]";
}

}
