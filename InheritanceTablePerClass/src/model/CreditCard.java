package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="CreditType")
public class CreditCard extends Payment {
private int cardNo;
private String cardtype;
public CreditCard() {
	// TODO Auto-generated constructor stub
}
public int getCardNo() {
	return cardNo;
}
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
public String getCardtype() {
	return cardtype;
}
public void setCardtype(String cardtype) {
	this.cardtype = cardtype;
}
@Override
public String toString() {
	return "CreditCard [cardNo=" + cardNo + ", cardtype=" + cardtype + "]";
}

}
