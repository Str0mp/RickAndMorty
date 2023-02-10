package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.model.*;
import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.service.CharacterService;
import cl.mobdev.rickandmorty.service.MainService;
import cl.mobdev.rickandmorty.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceImplTest {

    @Mock
    private CharacterService characterService;

    @Mock
    private LocationServiceImpl locationService;

    private MainService mainService;

    private Character character;
    private Location location;

    private Origin origin;

    @Before
    public void setUp() {
        mainService = new MainServiceImpl(characterService, locationService);
        character = Character.builder().build();
        origin = Origin.builder().build();
        character.setOrigin(origin);
        character.setName("Rick Sanchez");
        character.setStatus("Alive");
        character.getOrigin().setUrl("https://rickandmortyapi.com/api/location/1");

        location = Location.builder().build();
        location.setName("Earth (C-137)");
    }

    @Test
    public void getCharacterDto_returnsCorrectCharacterDto() throws IOException {
        when(characterService.getCharacterById(1)).thenReturn(character);
        when(locationService.getLocationById(1)).thenReturn(location);

        CharacterDTO characterDTO = mainService.getCharacterDto(1);

        assertEquals(characterDTO.getName(), "Rick Sanchez");
        assertEquals(characterDTO.getStatus(), "Alive");
       // assertEquals(characterDTO.getLocation(), "Earth (C-137)");
    }

    @Test
    public void getCharacterDto_returnsNullForEmptyLocationUrl() throws IOException {
        character.getOrigin().setUrl("");
        when(characterService.getCharacterById(1)).thenReturn(character);

        CharacterDTO characterDTO = mainService.getCharacterDto(1);

        assertEquals(characterDTO, null);
    }
}
