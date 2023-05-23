package magicbuilder.com.example.magicbuilder.model;


import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotNull
    private String login;
    @NotNull
    private String password;

    private LocalDate createdTime;

    private LocalDate lastUpdate;
    public UserWeb() {
    }

    public UserWeb(String login, @NotNull String password) {
        this.login = login;
        this.password = password;
        this.createdTime = LocalDate.now();
        this.lastUpdate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreatedTime() {

        return createdTime;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void changeLogin(String login){
        this.updated();
        this.login = login;
    }

    public void changePassword(String password) {
        this.updated();
        this.password = password;
    }

    public void updated(){
        this.lastUpdate = LocalDate.now();
    }
}
