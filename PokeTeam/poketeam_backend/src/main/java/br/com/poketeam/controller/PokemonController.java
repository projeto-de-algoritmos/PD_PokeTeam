package br.com.poketeam.controller;

import br.com.poketeam.exception.EmptyListPokemonException;
import br.com.poketeam.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping(path = "/listAll")
    public ResponseEntity<?> listAll(){
        try {
            return ResponseEntity.ok(service.listAll());
        } catch (EmptyListPokemonException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

//    @GetMapping(path = "/closestPokemon")
//    public ResponseEntity<?> closestPokemon(){
//        try {
//            return ResponseEntity.ok(service.closestPokemon());
//        } catch (EmptyListPokemonException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
}
