package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.client.CharacterClient;
import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.service.CharacterService;
import cl.mobdev.rickandmorty.utils.Constants;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class CharacterServiceImpl implements CharacterService {



    private final CharacterClient characterClient;

    public CharacterServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        characterClient = retrofit.create(CharacterClient.class);
    }

    @Override
    public Character getCharacterById (int id) throws IOException {
        Call<Character> characterCall = characterClient.getCharacter(id);
        Response<Character> response = characterCall.execute();
        return response.isSuccessful() ? response.body() : null;
    }
}
