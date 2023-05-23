package magicbuilder.com.example.magicbuilder.model.dto.response;

import magicbuilder.com.example.magicbuilder.model.UserWeb;

import java.time.LocalDate;


public class NewUserWebDtoResponse {



    private String login;

    private LocalDate createdTime;

    public NewUserWebDtoResponse(UserWeb userWeb) {

        this.login = userWeb.getLogin();
        this.createdTime = userWeb.getCreatedTime();
    }



    public String getLogin() {
        return login;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }
}
