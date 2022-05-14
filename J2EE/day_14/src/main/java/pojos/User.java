package pojos;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(name = "reg_amt")
	private double registrationAmmount;
	
	@Column(name = "reg_date")
	private LocalDate registrationDate;
	
	@Enumerated(value = EnumType.STRING)
	private Role role;

	// Constructors
	public User() {
	}


	public User(String name, String email, String password, double registrationAmmount, LocalDate registrationDate,
			Role role) {
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
		return "User\nId : " + super.getId() + "\nName : " + name + "\nEmail : " + email + "\nRegistration Ammount : "
				+ registrationAmmount + "\nRegistration Date : " + registrationDate + "\nRole : " + role + "\n";
	}

	// Getters & Setters
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
