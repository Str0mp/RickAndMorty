package cl.mobdev.rickandmorty.controller;

import cl.mobdev.rickandmorty.model.Character;
import cl.mobdev.rickandmorty.model.CharacterDTO;
import cl.mobdev.rickandmorty.model.Location;
import cl.mobdev.rickandmorty.service.CharacterService;
import cl.mobdev.rickandmorty.service.LocationService;
import cl.mobdev.rickandmorty.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
@RequestMapping("api/v1/main-controller")
public class MainController {

    @Autowired
    CharacterService characterService;

    @Autowired
    LocationService locationService;

    @Autowired
    MainService mainService;

    @GetMapping("/character/{id}")
    public Character getCharacterById (@PathVariable int id) throws IOException {
        return characterService.getCharacterById (id);
    }

    @GetMapping("/location/{id}")
    public Location getLocationById(@PathVariable int id) throws IOException {
        return locationService.getLocationById(id);
    }

    @GetMapping("/{id}")
    public CharacterDTO getMainController(@PathVariable int id) throws IOException {
        return mainService.getCharacterDto(id);
    }


}
