package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="ChequeInfo")
@PrimaryKeyJoinColumn (name="pid")
public class Cheque extends Payment{
private int chequeno;
private String chequetype;
public Cheque() {
	// TODO Auto-generated constructor stub
}
public int getChequeno() {
	return chequeno;
}
public void setChequeno(int chequeno) {
	this.chequeno = chequeno;
}
public String getChequetype() {
	return chequetype;
}
public void setChequetype(String chequetype) {
	this.chequetype = chequetype;
}
@Override
public String toString() {
	return "Cheque [chequeno=" + chequeno + ", chequetype=" + chequetype + "]";
}

}
