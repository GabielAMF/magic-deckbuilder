package magicbuilder.com.example.magicbuilder.model.dto;

import jakarta.validation.constraints.NotBlank;
import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;

public class NewDeckDTO {

    @NotBlank
    private String name;

    private FormatDTO format;

    public String getName() {
        return name;
    }

    public FormatDTO getFormat() {
        return format;
    }

    public NewDeckDTO(String name, FormatDTO format) {
        this.name = name;
        this.format = format;
    }

    public Deck convertToModel(UserWeb userWeb){
        return new Deck(this.name,this.format.convertToModel(),userWeb);
    }
}
