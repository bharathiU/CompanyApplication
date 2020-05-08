package com.employee.controller.exceptionhandler;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.exceptions.EmployerNotFoundException;
@ControllerAdvice
@RestController
public class ExceptionHandlerRestController {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest req){
		ErrorDetails details=new ErrorDetails("Employee is not found", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails> (details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployerNotFoundException(EmployerNotFoundException ex,WebRequest req){
		ErrorDetails details=new ErrorDetails("Employer is not found", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails> (details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allException(Exception ex,WebRequest req){
		ErrorDetails details=new ErrorDetails("you entered wrong details", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails> (details,HttpStatus.BAD_REQUEST);
	}

}
