package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_address")
public class Address extends BaseEntity {

	@Column(length = 30)
	private String city;

	@Column(length = 30)
	private String state;

	@Column(length = 30)
	private String country;

	@Column(length = 30, name = "zip_code")
	private String zipCode;

	// uni dir association from Address ----> Student (using shared PK approach)
	@OneToOne // mandatory , o.w will get MappingExc.
	@JoinColumn(name = "student_id", nullable = false) // optional BUT reco, col name n not null constraint added by
														// prog . BUT DOES NOT share the PK with Student

	@MapsId // to specify shared PK approach
	private Student student;

	public Address() {
	}

	public Address(String city, String state, String country, String zipCode) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address id " + getId() + " [city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + "]";
	}

}
