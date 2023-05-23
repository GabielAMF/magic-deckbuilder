package magicbuilder.com.example.magicbuilder.model.dto.response;

import magicbuilder.com.example.magicbuilder.model.UserWeb;

public class UserWebDtoDetailedResponse {

    private String login;

    private String createdTime;

    private String lastUpdated;

    public UserWebDtoDetailedResponse(UserWeb userWeb){
        this.login = userWeb.getLogin();
        this.createdTime = userWeb.getCreatedTime().toString();
        this.lastUpdated = userWeb.getLastUpdate().toString();
    }

    public String getLogin() {
        return login;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
