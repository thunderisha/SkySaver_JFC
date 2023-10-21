package al.jfc.exceptions;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JFCException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private final List<String> messages;
	
	public JFCException(String message) {
		super(message);
		this.messages = null;
	}
	public JFCException(List<String> messages) {
		super("");
		this.messages = messages;
	}
	public JFCException(String message, List<String> messages) {
		super(message);
		this.messages = messages;
	}
}
