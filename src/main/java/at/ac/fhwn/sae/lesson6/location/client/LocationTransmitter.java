package at.ac.fhwn.sae.lesson6.location.client;

import at.ac.fhwn.sae.lesson4.NmeaReaderAplikation;
import at.ac.fhwn.sae.lesson4.SaePoint;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class LocationTransmitter {



    public static void main(String[] args) {

        File file = new File(NmeaReaderAplikation.class.getClassLoader().getResource("auto.txt").getFile());

        NmeaReaderAplikation nmeaReader = new NmeaReaderAplikation(file);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    SaePoint saePoint = nmeaReader.readPoint();
                    System.out.println(saePoint);
                    LocationClientService.sendLocation(saePoint);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Timer timer = new Timer("timerTask");

        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }
}
