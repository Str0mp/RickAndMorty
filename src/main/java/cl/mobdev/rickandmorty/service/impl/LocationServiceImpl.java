package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.client.LocationClient;
import cl.mobdev.rickandmorty.model.Location;
import cl.mobdev.rickandmorty.service.LocationService;
import cl.mobdev.rickandmorty.utils.Constants;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationClient locationClient;

    public LocationServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        locationClient = retrofit.create(LocationClient.class);
    }

    @Override
    public Location getLocationById(int id) throws IOException {
        Call<Location> locationCall = locationClient.getLocation(id);
        Response<Location> response = locationCall.execute();
        return response.isSuccessful() ? response.body() : null;
    }
}
