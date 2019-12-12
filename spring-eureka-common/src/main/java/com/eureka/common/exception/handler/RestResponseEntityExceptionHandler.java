package com.eureka.common.exception.handler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.eureka.common.api.enums.RestApiResponseStatus;
import com.eureka.common.api.response.ApiResponse;
import com.eureka.common.exception.DefectTrackerException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger logger = LogManager.getLogger(ResponseEntityExceptionHandler.class);

  @ExceptionHandler
  protected ResponseEntity<ApiResponse> handleServerException(DefectTrackerException ex, WebRequest request) {
	  logger.error("Defect Tracker Exception occured", ex);
    return new ResponseEntity<ApiResponse>(new ApiResponse(RestApiResponseStatus.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  
}