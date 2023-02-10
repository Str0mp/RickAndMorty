package cl.mobdev.rickandmorty.service;

import cl.mobdev.rickandmorty.model.CharacterDTO;

import java.io.IOException;

public interface MainService {

    CharacterDTO getCharacterDto(int id) throws IOException;

}
