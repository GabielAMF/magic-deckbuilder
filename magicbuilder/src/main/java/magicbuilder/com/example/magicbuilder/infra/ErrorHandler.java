package magicbuilder.com.example.magicbuilder.infra;

import jakarta.persistence.EntityNotFoundException;
import magicbuilder.com.example.magicbuilder.model.dto.infra.FieldErrorValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequest(MethodArgumentNotValidException ex){
        List<FieldError> errors = ex.getFieldErrors();
        List<FieldErrorValidationDto> fieldErrorValidationDtos = new ArrayList<>();
        for (FieldError error:errors) {
            fieldErrorValidationDtos.add(new FieldErrorValidationDto(error));
        }
        return ResponseEntity.badRequest().body(fieldErrorValidationDtos);
    }


}
