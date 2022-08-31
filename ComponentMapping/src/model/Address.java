package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
private int streetno;

private String landmark;
private String city;
public Address() {
	// TODO Auto-generated constructor stub
}
public int getStreetno() {
	return streetno;
}
public void setStreetno(int streetno) {
	this.streetno = streetno;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Address [streetno=" + streetno + ", landmark=" + landmark + ", city=" + city + "]";
}

}
