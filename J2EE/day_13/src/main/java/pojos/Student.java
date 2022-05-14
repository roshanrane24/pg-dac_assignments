package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

	@Column(length = 30)
	private String name;

	@Column(length = 30, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course chosenCourse;

	@Embedded
	private AdharCard adhar;

	@ElementCollection
	@CollectionTable(name = "student_hobbies", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "hobbies", length = 40, unique = false)
	private List<String> hobbies = new ArrayList<>();

	@ElementCollection // mandatory
	@CollectionTable(name = "student_qualifications", joinColumns = @JoinColumn(name = "student_id")) // optional But
																										// reco for
																										// specifying
																										// name of the
																										// table n FK
																										// column
	private List<EducationQulification> qualifications = new ArrayList<>();

	public Student() {
	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	public AdharCard getAdhar() {
		return adhar;
	}

	public void setAdhar(AdharCard adhar) {
		this.adhar = adhar;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<EducationQulification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<EducationQulification> qualifications) {
		this.qualifications = qualifications;
	}

	public void addQualification(EducationQulification education) {
		this.qualifications.add(education);
	}

	public void removeQualification(EducationQulification education) {
		this.qualifications.remove(education);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}

}
