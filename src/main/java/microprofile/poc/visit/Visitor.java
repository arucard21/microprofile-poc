package microprofile.poc.visit;

import java.net.URI;
import java.time.ZonedDateTime;

public class Visitor {
	private String name;
	private String organization;
	private String telephoneNumber;
	private String email;
	private boolean confidential;
	private ZonedDateTime expectedArrival;
	private ZonedDateTime expectedDeparture;
	private ZonedDateTime actualArrival;
	private ZonedDateTime actualDeparture;
	private String identificationNumber;
	private String identificationType;
	private URI assigned; //badge
	private URI attending; //reservation

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isConfidential() {
		return confidential;
	}
	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}
	public ZonedDateTime getExpectedArrival() {
		return expectedArrival;
	}
	public void setExpectedArrival(ZonedDateTime expectedArrival) {
		this.expectedArrival = expectedArrival;
	}
	public ZonedDateTime getExpectedDeparture() {
		return expectedDeparture;
	}
	public void setExpectedDeparture(ZonedDateTime expectedDeparture) {
		this.expectedDeparture = expectedDeparture;
	}
	public ZonedDateTime getActualArrival() {
		return actualArrival;
	}
	public void setActualArrival(ZonedDateTime actualArrival) {
		this.actualArrival = actualArrival;
	}
	public ZonedDateTime getActualDeparture() {
		return actualDeparture;
	}
	public void setActualDeparture(ZonedDateTime actualDeparture) {
		this.actualDeparture = actualDeparture;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	public URI getAssigned() {
		return assigned;
	}
	public void setAssigned(URI assigned) {
		this.assigned = assigned;
	}
	public URI getAttending() {
		return attending;
	}
	public void setAttending(URI attending) {
		this.attending = attending;
	}
}
