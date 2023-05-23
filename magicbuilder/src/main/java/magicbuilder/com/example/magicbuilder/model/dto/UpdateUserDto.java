package magicbuilder.com.example.magicbuilder.model.dto;

import magicbuilder.com.example.magicbuilder.model.UserWeb;

public class UpdateUserDto {

    private String login;

    private String password;

    public UpdateUserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

   /* public UserWeb convertToModel(){
        return new UserWeb(this.login,this.password);
    }*/

}
