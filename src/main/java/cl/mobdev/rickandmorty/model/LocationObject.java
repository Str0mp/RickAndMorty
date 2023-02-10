package cl.mobdev.rickandmorty.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationObject {

    private String name;
    private String url;
}
