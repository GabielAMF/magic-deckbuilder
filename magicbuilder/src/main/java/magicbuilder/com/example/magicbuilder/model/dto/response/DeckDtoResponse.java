package magicbuilder.com.example.magicbuilder.model.dto.response;

import magicbuilder.com.example.magicbuilder.model.Deck;

public class DeckDtoResponse {

    private String name;

    private String legal;

    private String identity;

    private String format;

    public DeckDtoResponse(Deck deck) {
        this.name = deck.getName();
        this.legal = deck.getLegal().toString();
        this.identity = deck.getIdentity();
        this.format = deck.getFormat().getFormatName();
    }

    public String getName() {
        return name;
    }

    public String getLegal() {
        return legal;
    }

    public String getIdentity() {
        return identity;
    }

    public String getFormat() {
        return format;
    }
}
