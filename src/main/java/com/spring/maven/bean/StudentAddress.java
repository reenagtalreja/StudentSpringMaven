package com.spring.maven.bean;
/* Not needed is used to adding address to the above program*/
public class StudentAddress {
private Integer addressId;
private Integer studentId;
private String address;
private String city;
private String state;
private String zip;
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public StudentAddress(Integer addressId, Integer studentId, String address, String city, String state, String zip) {
	super();
	this.addressId = addressId;
	this.studentId = studentId;
	this.address = address;
	this.city = city;
	this.state = state;
	this.zip = zip;
}
public StudentAddress() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "StudentAddress [addressId=" + addressId + ", studentId=" + studentId + ", address=" + address + ", city="
			+ city + ", state=" + state + ", zip=" + zip + "]";
}

}
