package microprofile.poc.visit;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.ws.rs.core.MediaType;

@Schema(name="Visit")
public class Visit {
	public static final String MEDIATYPE_STRING = "application/x.visit-v1+json";
	public static final MediaType MEDIATYPE = MediaType.valueOf(MEDIATYPE_STRING);

	@Schema(required = false, description = "Reason for visit")
	private String reason;
	/**
	 * This amountOfVisitors may exceed the size of the list of the "visitors" field to allow for unregistered visitors.
	 */
	private int amountOfVisitors;
	private ZonedDateTime cancelationDate;
	private List<Visitor> visitors;
	private List<URI> host; // person
	private List<URI> assigned; // parking location

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getAmountOfVisitors() {
		return amountOfVisitors;
	}
	public void setAmountOfVisitors(int amountOfVisitors) {
		this.amountOfVisitors = amountOfVisitors;
	}
	public ZonedDateTime getCancelationDate() {
		return cancelationDate;
	}
	public void setCancelationDate(ZonedDateTime cancelationDate) {
		this.cancelationDate = cancelationDate;
	}
	public List<Visitor> getVisitors() {
		return visitors;
	}
	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
	public List<URI> getHost() {
		return host;
	}
	public void setHost(List<URI> host) {
		this.host = host;
	}
	public List<URI> getAssigned() {
		return assigned;
	}
	public void setAssigned(List<URI> assigned) {
		this.assigned = assigned;
	}
}
