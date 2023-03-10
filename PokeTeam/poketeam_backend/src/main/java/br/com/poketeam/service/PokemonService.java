package br.com.poketeam.service;

import br.com.poketeam.dto.PokemonDTO;
import br.com.poketeam.model.Pokemon;
import br.com.poketeam.repository.PokemonRepository;
import br.com.poketeam.util.KnapSackUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PokemonService {
    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<PokemonDTO> listAll() {
        int [] array = new int[50];
        Random random = new Random();
        boolean temnumero = false;
        for (int i =0; i < 50; i ++) {
            int valor = random.nextInt(150) + 1;
            for (int j = 0; j < 50; j ++) {
                if (array[j] == valor) {
                    j = 50;
                    temnumero = true;
                }
            }
            if (!temnumero) {
                array[i] = valor;
            } else {
                temnumero = false;
                i--;
            }
        }
        List<PokemonDTO> pokemonDTOList = new ArrayList<PokemonDTO>(50);
        for (int i = 0; i < 50; i++){
            Optional<Pokemon> optPokemon = repository.findById((long) array[i]);
            pokemonDTOList.add(new PokemonDTO(optPokemon.get()));
        }
        return pokemonDTOList;
    }

    public List<PokemonDTO> bestTeamPokemon(List<PokemonDTO> listPokemonDTO) {
        List<PokemonDTO> bestTeamDTO = new ArrayList<>();
        Integer damage[] = new Integer[listPokemonDTO.size()];
        int i = 0;
        for (PokemonDTO dto : listPokemonDTO) {
            damage[i] = dto.getDamage();
            i++;
        }
        Integer health[] = new Integer[listPokemonDTO.size()];
        int j = 0;
        for (PokemonDTO pokemonDTO : listPokemonDTO) {
            health[j] = pokemonDTO.getHealth();
            j++;
        }
        Integer time = 2000;
        int[] indexes = KnapSackUtil.knapSack(time, health, damage, 6);
        for (int k = 0; k < indexes.length; k++) {
            bestTeamDTO.add(listPokemonDTO.get(indexes[k]));
        }
        return bestTeamDTO;
    }
}
