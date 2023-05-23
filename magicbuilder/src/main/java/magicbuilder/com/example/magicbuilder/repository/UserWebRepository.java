package magicbuilder.com.example.magicbuilder.repository;

import magicbuilder.com.example.magicbuilder.model.UserWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserWebRepository extends JpaRepository<UserWeb,Long> {

    Optional<UserWeb> findByLogin(String login);



}
