package br.com.proonto.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String MESSAGE_RESOURCE = "Resource not found";
    public static final String MESSAGE_PROCEED = "Problem to proceed";
    Date timeStamp = new Date();
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError(MESSAGE_RESOURCE);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError(MESSAGE_PROCEED);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(NotAuthorizateException.class)
    public final ResponseEntity<StandardError> notAuthorized(NotAuthorizateException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.UNAUTHORIZED.value());
        err.setError(MESSAGE_PROCEED);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }

    @ExceptionHandler(MathOperationException.class)
    public final ResponseEntity<StandardError> mathOperationException(MathOperationException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError(MESSAGE_PROCEED);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


    @ExceptionHandler(ErrorUploadFileException.class)
    public final ResponseEntity<StandardError> errorUploadFileException(ErrorUploadFileException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setError("Problem to upload file");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
    @ExceptionHandler(FileNotFoundException.class)
    public final ResponseEntity<StandardError> errorUploadFileException(FileNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("The file was not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public final ResponseEntity<StandardError> dataAlreadyExistException(DataAlreadyExistException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Problem to integraty violation");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public final ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(timeStamp);
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Data base exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ValidationErros> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
//        ValidationErros err = new ValidationErros();
//        err.setTimestamp(timeStamp);
//        err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
//        err.setError("Error to validate some attribute of entity");
//        err.setMessage(e.getMessage());
//        err.setPath(request.getRequestURI());
//
//        for(FieldError f: e.getBindingResult().getFieldErrors()){
//            err.addError(f.getField(), f.getDefaultMessage());
//        }
//        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
//    }



}
