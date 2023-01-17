package at.ac.fhwn.sae.lesson5.location.server;

import at.ac.fhwn.sae.lesson4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;

@Service
public class LocationService {

    Hashtable<Integer, ArrayList<SaePoint>> locations = new Hashtable<>();

    public void addLocation(int id, SaePoint saePoint) {
        if (locations.containsKey(id)) {
            ArrayList<SaePoint> temp = locations.get(id);
            temp.add(saePoint);
            locations.put(id, temp);
        }else{
            ArrayList<SaePoint> location = new ArrayList<>();
            location.add((saePoint));
            locations.put(id, location);
        }
    }

    public SaePoint getLocation(int id, int index) {
        if (index < 0) {
            ArrayList<SaePoint> temp = locations.get(id);
            return locations.get(id).get(temp.size() + index);
        }
        return locations.get(id).get(index);
    }

    public ArrayList<SaePoint> getLocations(int id) {
        return locations.get(id);
    }

    public Hashtable<Integer, ArrayList<SaePoint>> getAllLocations(){
        return locations;
    }
}
