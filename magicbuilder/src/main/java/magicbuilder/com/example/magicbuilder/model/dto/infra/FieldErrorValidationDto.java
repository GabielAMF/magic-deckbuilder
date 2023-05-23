package magicbuilder.com.example.magicbuilder.model.dto.infra;

import org.springframework.validation.FieldError;

public class FieldErrorValidationDto {

    private String field;

    private String message;

    public FieldErrorValidationDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public FieldErrorValidationDto(FieldError fieldError){
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
