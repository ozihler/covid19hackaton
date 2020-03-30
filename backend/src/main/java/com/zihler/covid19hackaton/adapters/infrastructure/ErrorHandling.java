package com.zihler.covid19hackaton.adapters.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ErrorHandling {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandling.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorViewModel> handleGenericException(Exception bad) {
        log(bad);
        return status(I_AM_A_TEAPOT).body(new ErrorViewModel(Arrays.toString(bad.getStackTrace()) + ", " + bad.getMessage()));
    }

    private void log(Exception bad) {
        logger.error("An exception was thrown. ", bad);
    }
}
