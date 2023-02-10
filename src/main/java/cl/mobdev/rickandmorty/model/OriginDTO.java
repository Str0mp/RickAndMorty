package cl.mobdev.rickandmorty.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OriginDTO {

    private String name;
    private String url;
    private String dimensions;
    private String[] residents;

}
