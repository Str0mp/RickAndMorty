package cl.mobdev.rickandmorty.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Builder
public class Character {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;

    private String gender;
    private Origin origin;
    private LocationObject location;
    private String image;

    private String[] episode;
    private String url;
    private Date created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
