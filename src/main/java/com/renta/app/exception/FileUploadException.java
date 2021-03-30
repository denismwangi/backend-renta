package com.renta.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.renta.app.payload.response.MessageResponse;

@ControllerAdvice
public class FileUploadException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<MessageResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	  
   // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse("File too large!", "0"));
   // return ResponseEntity.ok(new MessageResponse("User registered successfully!", "1"));
	  return null;
  }
}
