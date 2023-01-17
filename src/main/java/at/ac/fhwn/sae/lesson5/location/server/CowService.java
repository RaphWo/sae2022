package at.ac.fhwn.sae.lesson5.location.server;

import at.ac.fhwn.sae.lesson3.AnimalFarm.Cow;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class CowService {

    Hashtable<Integer, Cow> cows = new Hashtable<>();

    public void helloWorld(Cow cow, int index) {
        System.out.println("Hello World");
        cows.put(index, cow);
    }

    public Hashtable getCows() {
        return cows;
    }
}