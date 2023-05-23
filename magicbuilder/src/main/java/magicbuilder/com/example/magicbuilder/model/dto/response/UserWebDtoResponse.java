package magicbuilder.com.example.magicbuilder.model.dto.response;

import magicbuilder.com.example.magicbuilder.model.UserWeb;

public class UserWebDtoResponse {

    private String login;

    private String password;

    public UserWebDtoResponse(UserWeb userWeb){
        this.login = userWeb.getLogin();
        this.password = userWeb.getPassword();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
