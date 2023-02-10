package cl.mobdev.rickandmorty.service;

import cl.mobdev.rickandmorty.model.Location;

import java.io.IOException;

public interface LocationService {

    Location getLocationById(int id) throws IOException;

}
