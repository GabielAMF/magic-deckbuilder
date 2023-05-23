package magicbuilder.com.example.magicbuilder.service;

import jakarta.persistence.EntityManager;
import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import magicbuilder.com.example.magicbuilder.model.dto.NewDeckDTO;
import magicbuilder.com.example.magicbuilder.repository.DeckRepository;
import magicbuilder.com.example.magicbuilder.repository.UserWebRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckService {
    @Autowired
    DeckRepository deckRepository;

    @Autowired
    UserWebRepository userWebRepository;

    public ResponseEntity saveNewDeck(NewDeckDTO newDeckDTO, Long id){

        Optional<UserWeb> userWeb = userWebRepository.findById(id);
        if (userWeb.isEmpty()) return ResponseEntity.notFound().build();
        Deck deck = newDeckDTO.convertToModel(userWeb.get());
        deckRepository.save(deck);
        return ResponseEntity.ok().build();

}

    public Page<Deck> findAllDecksFromUser(Long id, Pageable pageable){
        Optional<UserWeb> optionalUserWeb= userWebRepository.findById(id);
        if (optionalUserWeb.isEmpty()) return null;
        Page<Deck> decks = deckRepository.findAllByUser(optionalUserWeb.get(),pageable);
        return decks;
    }

}
