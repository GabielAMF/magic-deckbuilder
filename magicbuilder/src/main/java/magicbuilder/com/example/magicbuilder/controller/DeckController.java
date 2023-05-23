package magicbuilder.com.example.magicbuilder.controller;

import jakarta.transaction.Transactional;
import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import magicbuilder.com.example.magicbuilder.model.dto.NewDeckDTO;
import magicbuilder.com.example.magicbuilder.model.dto.response.DeckDtoResponse;
import magicbuilder.com.example.magicbuilder.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;
    @PutMapping("/new-deck/{id}")
    @Transactional
    public ResponseEntity newDeckFromUser(@PathVariable Long id, @RequestBody NewDeckDTO newDeckDTO){


        return deckService.saveNewDeck(newDeckDTO,id);
    }

    @GetMapping("/all-decks/{id}")
    public ResponseEntity<Page<DeckDtoResponse>> getAllDecks(@PathVariable Long id,@PageableDefault(size = 10,sort = "name") Pageable pageable){
        Page<Deck> decks = deckService.findAllDecksFromUser(id,pageable);
        return ResponseEntity.ok(decks.map(DeckDtoResponse::new));
    }

}
