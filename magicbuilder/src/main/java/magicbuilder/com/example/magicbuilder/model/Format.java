package magicbuilder.com.example.magicbuilder.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Format {

    //Provavelmente sera mudado para Enum
    private String formatName;

    private int minCards;

    private int maxCards;

    private Boolean highlander;

    private Boolean matchIdentity;

    public Format() {
    }

    public Format(String formatName, int minCards, int maxCards, Boolean highlander, Boolean matchIdentity) {
        this.formatName = formatName;
        this.minCards = minCards;
        this.maxCards = maxCards;
        this.highlander = highlander;
        this.matchIdentity = matchIdentity;
    }

    public String getFormatName() {
        return formatName;
    }

    public int getMinCards() {
        return minCards;
    }

    public int getMaxCards() {
        return maxCards;
    }

    public Boolean getHighlander() {
        return highlander;
    }

    public Boolean getMatchIdentity() {
        return matchIdentity;
    }
}
