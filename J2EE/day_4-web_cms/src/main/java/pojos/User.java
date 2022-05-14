package pojos;

import java.sql.Date;

public class User {
	// Data members
	private int id;
	private String name;
	private String email;
	private String password;
	private double registrationAmmount;
	private Date registrationDate;
	private String role;

	// Constructors
	public User() {
	}

	public User(int id, String name, String email, String password, double registrationAmmount, Date registrationDate,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmmount = registrationAmmount;
		this.registrationDate = registrationDate;
		this.role = role;
	}

	// To String
	@Override
	public String toString() {
		return "User\nId : " + id + "\nName : " + name + "\nEmail : " + email + "\nRegistration Ammount : "
				+ registrationAmmount + "\nRegistration Date : " + registrationDate + "\nRole : " + role + "\n";
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistrationAmmount() {
		return registrationAmmount;
	}

	public void setRegistrationAmmount(double registrationAmmount) {
		this.registrationAmmount = registrationAmmount;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
