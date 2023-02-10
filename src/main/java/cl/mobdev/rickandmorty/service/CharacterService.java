package cl.mobdev.rickandmorty.service;

import cl.mobdev.rickandmorty.model.Character;

import java.io.IOException;

public interface CharacterService {

    Character getCharacterById (int id) throws IOException;

}
