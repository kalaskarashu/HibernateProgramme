package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table (name="PayInfo")
public class Payment {
	@Id 
	@Column (name="pid")
private int payid;
private double payamt;
private Date paydate;
public Payment() {
	// TODO Auto-generated constructor stub
}
public int getPayid() {
	return payid;
}
public void setPayid(int payid) {
	this.payid = payid;
}
public double getPayamt() {
	return payamt;
}
public void setPayamt(double payamt) {
	this.payamt = payamt;
}
public Date getPaydate() {
	return paydate;
}
public void setPaydate(Date paydate) {
	this.paydate = paydate;
}
@Override
public String toString() {
	return "Payment [payid=" + payid + ", payamt=" + payamt + ", paydate=" + paydate + "]";
}

}
