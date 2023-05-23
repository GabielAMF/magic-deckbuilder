package magicbuilder.com.example.magicbuilder.model;

import jakarta.persistence.*;
import magicbuilder.com.example.magicbuilder.model.dto.response.DeckDtoResponse;
import org.jetbrains.annotations.NotNull;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean legal;

    private String identity;

    @Embedded
    private Format format;
    @ManyToOne
    private UserWeb user;

    public Deck() {
    }

    public Deck(String name,Format format,UserWeb userWeb) {
        this.name = name;
        this.format = format;
        this.user = userWeb;
        this.legal = Boolean.FALSE;
    }


    public String getName() {
        return name;
    }

    public Boolean getLegal() {
        return legal;
    }

    public String getIdentity() {
        return identity;
    }

    public Format getFormat() {
        return format;
    }

    public UserWeb getUser() {
        return user;
    }


}
