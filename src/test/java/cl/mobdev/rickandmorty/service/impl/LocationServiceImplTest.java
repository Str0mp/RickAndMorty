package cl.mobdev.rickandmorty.service.impl;

import cl.mobdev.rickandmorty.client.LocationClient;
import cl.mobdev.rickandmorty.model.Location;
import cl.mobdev.rickandmorty.service.LocationService;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

    @InjectMocks
    LocationServiceImpl locationServiceImpl;

    @Mock
    LocationClient locationClient;

    @Mock
    Call<Location> locationCall;

    @Mock
    Location location;

    @Before
    public void setUp() throws ParseException {
        location = Location.builder().build();
        location.setId(1);
        location.setName("Earth (C-137)");
        location.setType("Planet");
        location.setDimension("Dimension C-137");
        String[] residents =  new String[]{"https://rickandmortyapi.com/api/character/38",
                "https://rickandmortyapi.com/api/character/45",
                "https://rickandmortyapi.com/api/character/71",
                "https://rickandmortyapi.com/api/character/82",
                "https://rickandmortyapi.com/api/character/83",
                "https://rickandmortyapi.com/api/character/92",
                "https://rickandmortyapi.com/api/character/112",
                "https://rickandmortyapi.com/api/character/114",
                "https://rickandmortyapi.com/api/character/116",
                "https://rickandmortyapi.com/api/character/117",
                "https://rickandmortyapi.com/api/character/120",
                "https://rickandmortyapi.com/api/character/127",
                "https://rickandmortyapi.com/api/character/155",
                "https://rickandmortyapi.com/api/character/169",
                "https://rickandmortyapi.com/api/character/175",
                "https://rickandmortyapi.com/api/character/179",
                "https://rickandmortyapi.com/api/character/186",
                "https://rickandmortyapi.com/api/character/201",
                "https://rickandmortyapi.com/api/character/216",
                "https://rickandmortyapi.com/api/character/239",
                "https://rickandmortyapi.com/api/character/271",
                "https://rickandmortyapi.com/api/character/302",
                "https://rickandmortyapi.com/api/character/303",
                "https://rickandmortyapi.com/api/character/338",
                "https://rickandmortyapi.com/api/character/343",
                "https://rickandmortyapi.com/api/character/356",
                "https://rickandmortyapi.com/api/character/394"};
        location.setResidents(residents);
        location.setUrl("https://rickandmortyapi.com/api/location/1");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        String dateInString = "10-11-2017 7:42:04 AM";
        Date date = formatter.parse(dateInString);
        location.setCreated(date);
    }

    @Test
    public void getLocationById_whenLocationExists_returnsLocation() throws IOException {
        when(locationClient.getLocation(1)).thenReturn(locationCall);
        when(locationCall.execute()).thenReturn(Response.success(location));

        Location result = locationServiceImpl.getLocationById(1);

        assertEquals(location, result);
    }

    @Test
    public void getLocationById_whenLocationDoesNotExist_returnsNull() throws IOException {
        when(locationClient.getLocation(anyInt())).thenReturn(locationCall);
        when(locationCall.execute()).thenReturn(Response.error(404, ResponseBody.create(MediaType.parse("application/json"), "")));

        Location result = locationServiceImpl.getLocationById(1);


        assertEquals(location.getId(), result.getId());
    }

}
