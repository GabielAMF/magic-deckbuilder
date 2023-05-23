package magicbuilder.com.example.magicbuilder.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class UserWebDTO {
    @NotBlank(message = "Campo login nao pode ser nulo")
    @Email(message = "Email deve ter formato de email")
    private String login;
    @NotBlank(message = "Senha nao pode ser vazia")
    private String password;


    public UserWebDTO(String login, @NotNull String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
    @NotNull
    public String getPassword() {
        return password;
    }



    public UserWeb convertToModel(){
        return new UserWeb(this.login,this.password);
    }
}
