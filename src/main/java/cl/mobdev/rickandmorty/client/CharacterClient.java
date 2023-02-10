package cl.mobdev.rickandmorty.client;

import cl.mobdev.rickandmorty.model.Character;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface CharacterClient {

    @GET("character/{idCharacter}")
    Call<Character> getCharacter(@Path("idCharacter") int idCharacter) throws IOException;

}
