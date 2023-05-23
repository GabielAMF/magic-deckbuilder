package magicbuilder.com.example.magicbuilder.service;

import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import magicbuilder.com.example.magicbuilder.model.dto.UpdateUserDto;
import magicbuilder.com.example.magicbuilder.model.dto.UserWebDTO;
import magicbuilder.com.example.magicbuilder.repository.DeckRepository;
import magicbuilder.com.example.magicbuilder.repository.UserWebRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserWebService {

    @Autowired
    private UserWebRepository userWebRepository;
    @Autowired
    private DeckRepository deckRepository;
    public UserWeb saveNewUser(UserWebDTO userWebDTO){
        //implementar envio de e-mail
        //implementar validacao
        //implementar possivel trycatch

        UserWeb userWeb = userWebDTO.convertToModel();
        userWebRepository.save(userWeb);
        return userWeb;

    }

    public Page<UserWeb> listAllUsers(Pageable pageable){
        return userWebRepository.findAll(pageable);

    }

    public UserWeb findUser(Long id){
        Optional<UserWeb> optionalUserWeb= userWebRepository.findById(id);
        if(optionalUserWeb.isEmpty()) return null;
        return optionalUserWeb.get();
    }

    public ResponseEntity updateUser(Long id, UpdateUserDto updateUserDto){
        Optional<UserWeb> optionalUserWeb = userWebRepository.findById(id);
        if(optionalUserWeb.isEmpty()) return ResponseEntity.notFound().build();
        UserWeb userWeb = optionalUserWeb.get();
        if(updateUserDto.getLogin()!=null) userWeb.changeLogin(updateUserDto.getLogin());
        if(updateUserDto.getPassword()!=null) userWeb.changePassword(updateUserDto.getPassword());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteUser(Long id) {
        Optional<UserWeb> optionalUserWeb = userWebRepository.findById(id);
        if (optionalUserWeb.isEmpty()) return ResponseEntity.notFound().build();
        userWebRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
