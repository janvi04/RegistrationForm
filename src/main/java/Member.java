
public class Member {
private String firstName, lastName,address,city,state,country,zipcode,phoneNumber,userName,password;


public Member() {
	super();
}

public Member(String firstName, String lastName, String address, String city, String state, String country,
		String zipcode, String phoneNumber, String userName, String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zipcode = zipcode;
	this.phoneNumber = phoneNumber;
	this.userName = userName;
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
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

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
