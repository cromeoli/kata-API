package syntaxt3rr0r.apikata.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeerNotFoundException.class)
    public ResponseEntity<APIError> handleBeerNotFound(BeerNotFoundException exception){
        APIError apiError = new APIError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(BreweryNotFoundException.class)
    public ResponseEntity<APIError> handleBreweryNotFound(BreweryNotFoundException exception){
        APIError apiError = new APIError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<APIError> handleCategoryNotFound(CategoryNotFoundException exception){
        APIError apiError = new APIError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(StyleNotFoundException.class)
    public ResponseEntity<APIError> handleStyleNotFound(StyleNotFoundException exception){
        APIError apiError = new APIError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }



    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLError(SQLException exception, WebRequest request){

        APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body,
                                                          HttpHeaders headers, HttpStatus status,
                                                          WebRequest request ){

        APIError apiError = new APIError(status, exception.getMessage());

        return ResponseEntity.status(status).body(apiError);
    }

}
