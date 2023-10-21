package al.jfc.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import al.jfc.utils.ResponseHandler;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(value = JFCException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException(JFCException ex) {
		if(ex.getMessages() == null) {
			return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getMessages());
		}
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseHandler.generateResponse("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = TransactionSystemException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleModelException(TransactionSystemException ex) {
		
		Exception e = ex;
		while(e.getCause() != null) {
			e = (Exception) e.getCause();
			if(e instanceof ConstraintViolationException) {
				Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) e).getConstraintViolations();
				String msg = "";
				for(ConstraintViolation<?> c: violations) {
					msg += c.getPropertyPath() + " : " + c.getMessage() + " ; ";
				}
				return ResponseHandler.generateResponse(msg.substring(0, msg.length()-3), HttpStatus.BAD_REQUEST);
			}
		}
		
		return ResponseHandler.generateResponse("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleCVException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		String msg = "";
		for(ConstraintViolation<?> c: violations) {
			msg += c.getPropertyPath() + " : " + c.getMessage() + " ; ";
		}
		return ResponseHandler.generateResponse(msg.substring(0, msg.length()-3), HttpStatus.BAD_REQUEST);
	}
	
}