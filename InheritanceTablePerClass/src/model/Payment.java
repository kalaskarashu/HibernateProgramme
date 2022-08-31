package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment {
@Id
private int payId;
private double payAmt;
private Date date;
public Payment() {
	// TODO Auto-generated constructor stub
}
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}
public double getPayAmt() {
	return payAmt;
}
public void setPayAmt(double payAmt) {
	this.payAmt = payAmt;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Payment [payId=" + payId + ", payAmt=" + payAmt + ", date=" + date + "]";
}

}
