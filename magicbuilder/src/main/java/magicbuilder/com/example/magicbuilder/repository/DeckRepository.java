package magicbuilder.com.example.magicbuilder.repository;

import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeckRepository extends JpaRepository<Deck,Long> {

    List<Deck> findAllByUser(UserWeb userWeb);

    Page<Deck> findAllByUser(UserWeb userWeb, Pageable pageable);
}
