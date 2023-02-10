package cl.mobdev.rickandmorty.utils;

import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.model.CharacterDTO;
import cl.mobdev.rickandmorty.model.Location;
import cl.mobdev.rickandmorty.model.OriginDTO;

import java.util.Arrays;

public class Utils {

    public static int obtainId(String inputString){
        String[] parts = inputString.split("/");
        return Integer.valueOf(parts[parts.length - 1]);
    }

    public static CharacterDTO characterToDto(Character character, Location location){
        CharacterDTO characterDTO = CharacterDTO.builder()
                .id(character.getId())
                .name(character.getName())
                .status(character.getStatus())
                .species(character.getSpecies())
                .type(character.getType())
                .episodeCount(countElements(character.getEpisode()))
                .origin(OriginDTO.builder()
                        .name(character.getOrigin().getName())
                        .url(character.getOrigin().getUrl())
                        .dimensions(location.getDimension())
                        .residents(location.getResidents())
                        .build())
                .build();
        return characterDTO;
    }

    public static int countElements(String[] array){
        if(array != null){
            return (int) Arrays.stream(array).count();
        }
      return 0;
    }

}
