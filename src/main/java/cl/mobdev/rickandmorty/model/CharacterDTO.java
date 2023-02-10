package cl.mobdev.rickandmorty.model;

import lombok.*;

@Data
@Builder
public class CharacterDTO {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episodeCount;
    private OriginDTO origin;
}
