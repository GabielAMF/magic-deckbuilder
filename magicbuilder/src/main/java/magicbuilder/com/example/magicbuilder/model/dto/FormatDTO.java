package magicbuilder.com.example.magicbuilder.model.dto;

import jakarta.validation.constraints.NotBlank;
import magicbuilder.com.example.magicbuilder.model.Format;

public class FormatDTO {


    private String formatName;

    private String minCards;

    private String maxCards;

    private String highlander;

    private String matchIdentity;

    public FormatDTO(String formatName, String minCards, String maxCards, String highlander, String matchIdentity) {
        this.formatName = formatName;
        this.minCards = minCards;
        this.maxCards = maxCards;
        this.highlander = highlander;
        this.matchIdentity = matchIdentity;
    }

    public String getFormatName() {
        return formatName;
    }

    public String getMinCards() {
        return minCards;
    }

    public String getMaxCards() {
        return maxCards;
    }

    public String getHighlander() {
        return highlander;
    }

    public String getMatchIdentity() {
        return matchIdentity;
    }

    public Format convertToModel(){
        return new Format(this.formatName,Integer.valueOf(this.minCards),Integer.valueOf(this.maxCards),Boolean.parseBoolean(this.highlander),Boolean.parseBoolean(this.matchIdentity));
    }
}
