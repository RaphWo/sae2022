package at.ac.fhwn.sae.lesson5.location.server;

import at.ac.fhwn.sae.lesson4.SaePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Hashtable;

@RestController
public class LocationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

    @GetMapping("/setLocation")
    public SaePoint setLocation(
            @RequestParam("id") int id,
            @RequestParam("time") String time,
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam("satNr") int numberOfSatelites,
            @RequestParam("fixQ") int fix
    ){
        SaePoint saePoint = new SaePoint(time, lat, lon, numberOfSatelites, fix);
        locationService.addLocation(id, saePoint);
        logger.info("Point recieved: ID= " + id + " Lat= " + lat + " Lon= " + lon);
        return saePoint;
    }

    @GetMapping("/location")
    public SaePoint location(
            @RequestParam("id") int id,
            @RequestParam(value = "index", required = false) Integer index
    ){
        if(index == null){
            index = 0;
        }
        index++;
        return locationService.getLocation(id, index * -1);
    }

    @GetMapping("/locations")
    public ArrayList<SaePoint> locations(
            @RequestParam("id") int id
    ){
        return locationService.getLocations(id);
    }

    @GetMapping("/allLocations")
    public Hashtable<Integer, ArrayList<SaePoint>> allLocations(){
        return locationService.getAllLocations();
    }

}
