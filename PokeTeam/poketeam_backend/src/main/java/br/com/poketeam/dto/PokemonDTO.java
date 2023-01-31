package br.com.poketeam.dto;

import br.com.poketeam.model.Pokemon;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PokemonDTO {
    private Long id;
    private String name;
    private String url;
    private Integer damage;
    private Integer health;

    public PokemonDTO(Pokemon pokemon){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.url = pokemon.getUrl();
        this.damage = pokemon.getDamage();
        this.health = pokemon.getHealth();
    }
}

