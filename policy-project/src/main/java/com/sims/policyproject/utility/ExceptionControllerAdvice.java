package com.sims.policyproject.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sims.policyproject.exception.PolicyException;

@RestControllerAdvice
@PropertySource("classpath:messages.properties")
public class ExceptionControllerAdvice {

	 private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

	    @Autowired
	    private Environment environment;

	    @ExceptionHandler(PolicyException.class)
	    public ResponseEntity<ErrorInfo> rewardManagementExceptionHandler(PolicyException e) {
	        LOGGER.error(e.getMessage(), e);

	        String errorMessageKey = e.getMessage();
	        String errorMessage = environment.getProperty(errorMessageKey, "An error occurred");

	        ErrorInfo errorInfo = new ErrorInfo();
	        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
	        errorInfo.setErrorMessage(errorMessage);

	        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	    }
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleGeneralException(Exception e) {
	        LOGGER.error("An unexpected error occurred", e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
	    }
}
