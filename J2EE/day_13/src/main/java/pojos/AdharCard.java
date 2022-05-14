package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdharCard {

	@Column(name = "adhar_id", nullable = true, unique = true, length = 12)
	private String cardNumber;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@Column(length = 25)
	private String location;

	public AdharCard() {
	}

	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}

}
