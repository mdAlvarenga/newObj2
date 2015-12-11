package nadaTesteable;

public class Correo {
	
	private String to;
	private String subject;
	private String body;
		
	public Correo(String to,String subject,String body){
		this.setTo(to);
		this.setSubject(subject);
		this.setBody(body);
	}
	  
	public void setBody(final String body) {
	    this.body = body;
	}
	  
	public void setSubject(final String subject) {
	    this.subject = subject;
	}
	  
	public void setTo(final String to) {
	    this.to = to;
	}
	
	public String getBody() {
	    return this.body ;
	}
	  
	public String getSubject() {
	    return this.subject; 
	}
	  
	public String getTo() {
	    return this.to ;
	}
}