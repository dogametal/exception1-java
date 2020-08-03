package model.exception;

// If this extends was RunTimeException compiller wont be obligation treatment
public class DomainException extends Exception{
	private static final long serialVersionUID = 1L;

	public DomainException (String msg) {
		super(msg);
	}
	
	
}
