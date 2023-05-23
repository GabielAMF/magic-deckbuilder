package magicbuilder.com.example.magicbuilder.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import magicbuilder.com.example.magicbuilder.model.Deck;
import magicbuilder.com.example.magicbuilder.model.UserWeb;
import magicbuilder.com.example.magicbuilder.model.dto.UpdateUserDto;
import magicbuilder.com.example.magicbuilder.model.dto.UserWebDTO;
import magicbuilder.com.example.magicbuilder.model.dto.response.DeckDtoResponse;
import magicbuilder.com.example.magicbuilder.model.dto.response.NewUserWebDtoResponse;
import magicbuilder.com.example.magicbuilder.model.dto.response.UserWebDtoDetailedResponse;
import magicbuilder.com.example.magicbuilder.model.dto.response.UserWebDtoResponse;
import magicbuilder.com.example.magicbuilder.repository.DeckRepository;
import magicbuilder.com.example.magicbuilder.service.UserWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserAdmController {

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    private UserWebService userWebService;
    @PostMapping("/new-user")
    @Transactional
    public ResponseEntity new_user(@RequestBody @Valid UserWebDTO userWebDTO, UriComponentsBuilder uriComponentsBuilder){
        UserWeb userWeb = userWebService.saveNewUser(userWebDTO);
        NewUserWebDtoResponse newUserWebDtoResponse = new NewUserWebDtoResponse(userWeb);
        URI uri  = uriComponentsBuilder.path("/new-user/{id}").buildAndExpand(userWeb.getId()).toUri();
        return ResponseEntity.created(uri).body(newUserWebDtoResponse);
    }

    @GetMapping("/")
    public Page<UserWebDtoResponse> listAllUsers(@PageableDefault(size = 10,sort = "login") Pageable pageable){
        return userWebService.listAllUsers(pageable).map(UserWebDtoResponse::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserWebDtoDetailedResponse> detailUser(@PathVariable Long id){
        UserWeb userWeb = userWebService.findUser(id);
        if (userWeb == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new UserWebDtoDetailedResponse(userWeb));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto){
        return userWebService.updateUser(id,updateUserDto);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id){
        return userWebService.deleteUser(id);
    }









}
