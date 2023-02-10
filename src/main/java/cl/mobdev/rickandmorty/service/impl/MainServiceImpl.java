package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.model.CharacterDTO;
import cl.mobdev.rickandmorty.model.Location;
import cl.mobdev.rickandmorty.service.CharacterService;
import cl.mobdev.rickandmorty.service.MainService;
import cl.mobdev.rickandmorty.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    CharacterService characterService;

    @Autowired
    LocationServiceImpl locationService;

    public MainServiceImpl(CharacterService characterService, LocationServiceImpl locationService) {
        this.characterService = characterService;
        this.locationService = locationService;
    }


    @Override
    public CharacterDTO getCharacterDto(int id) throws IOException {
        Character character = characterService.getCharacterById(id);
        CharacterDTO characterDTO = null;
        if(!character.getOrigin().getUrl().isEmpty()){
            Location location = locationService.getLocationById(Utils.obtainId(character.getOrigin().getUrl()));
            characterDTO = Utils.characterToDto(character, location);
        }

        return characterDTO;
    }


}
