package cl.mobdev.rickandmorty.client;

import cl.mobdev.rickandmorty.model.Location;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface LocationClient {

    @GET("location/{idLocation}")
    Call<Location> getLocation(@Path("idLocation") int idLocation) throws IOException;
}
