package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.client.CharacterClient;
import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.service.CharacterService;
import cl.mobdev.rickandmorty.service.impl.CharacterServiceImpl;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class CharacterServiceImplTest {
    @Mock
    private Call<Character> characterCall;

    @Mock
    private CharacterClient characterClient;

    @InjectMocks
    private CharacterService characterService = new CharacterServiceImpl();

    private Character character;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        character = Character.builder().build();
        character.setId(1);
    }

    @Test
    public void getCharacterById_whenCharacterExists_returnsCharacter() throws IOException {
        when(characterClient.getCharacter(anyInt())).thenReturn(characterCall);
        when(characterCall.execute()).thenReturn(Response.success(character));

        Character result = characterService.getCharacterById(1);

        assertEquals(character, result);
    }

}
