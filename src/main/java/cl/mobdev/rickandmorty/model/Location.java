package cl.mobdev.rickandmorty.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Builder
public class Location {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private String[] residents;
    private String url;
    private Date created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
