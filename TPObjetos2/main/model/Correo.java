package model;

public class Correo {
	
	private String to;
	private String subject;
	private String body;
		
	public Correo(String to,String subject,String body){
		this.setTo(to);
		this.setSubject(subject);
		this.setBody(body);
	}
	
	//Getters and Setters
	public String getBody() {
		return this.body;
	}
	  
	public void setBody(final String body) {
	    this.body = body;
	}
	  
	public String getSubject() {
	    return this.subject;
	}
	  
	public void setSubject(final String subject) {
	    this.subject = subject;
	}
	
	public String getTo() {
	    return this.to;
	}
	  
	public void setTo(final String to) {
	    this.to = to;
	}
}