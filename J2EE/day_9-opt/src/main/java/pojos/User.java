package pojos;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class User {
	
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String reg_amt;
	private LocalDate reg_date;
	private String role;

}
