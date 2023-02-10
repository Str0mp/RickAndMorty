package cl.mobdev.rickandmorty.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Origin {

    private String name;
    private String url;
}
