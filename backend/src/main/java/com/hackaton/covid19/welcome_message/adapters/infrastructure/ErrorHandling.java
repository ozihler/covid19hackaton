package com.hackaton.covid19.welcome_message.adapters.infrastructure;

import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ErrorHandling {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandling.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorViewModel> handleGenericException(Exception bad) {
        log(bad);
        return status(I_AM_A_TEAPOT).body(new ErrorViewModel(Arrays.toString(bad.getStackTrace()) + ", " + bad.getMessage()));
    }

    @ExceptionHandler(value = UserAlreadyRegisteredException.class)
    public ResponseEntity<ErrorViewModel> handleUserAlreadyRegisteredException(Exception bad) {
        log(bad);
        return status(BAD_REQUEST).body(new ErrorViewModel(bad.getMessage() + "\n" + Arrays.toString(bad.getStackTrace())));
    }

    @ExceptionHandler(value = PandeBuddyNotFoundException.class)
    public ResponseEntity<ErrorViewModel> handlePandeBuddyNotFoundException(Exception bad) {
        log(bad);
        return status(NOT_FOUND)
                .body(new ErrorViewModel(bad.getMessage() + "\n" + Arrays.toString(bad.getStackTrace())));
    }

    private void log(Exception bad) {
        logger.error("An exception was thrown. ", bad);
    }
}
