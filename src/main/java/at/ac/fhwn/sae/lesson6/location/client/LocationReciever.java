package at.ac.fhwn.sae.lesson6.location.client;

import at.ac.fhwn.sae.lesson4.SaePoint;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class LocationReciever {
    public static Scanner in = new Scanner(System.in);

    static MainMenu showMenu(){
        System.out.println("Was möchten Sie tun?");
        System.out.println("");
        System.out.println(String.format("%-5s", "1.") + "Letze Position eines Transmitters");
        System.out.println(String.format("%-5s", "2.") + "Alle Positionen eines Transmitters");
        System.out.println(String.format("%-5s", "3.") + "Alle Positionen aller Transmitter");
        System.out.println(String.format("%-5s", "4.") + "Beenden");

        int input = in.nextInt();
        return MainMenu.values()[input-1];
    }

    public static void main(String[] args) {
        MainMenu currentaction = showMenu();
        while (currentaction != MainMenu.EXIT){
            if (currentaction == MainMenu.LAST_POSITION){
                System.out.println("Bitte geben Sie die ID des Transmitters ein: ");
                int id = in.nextInt();
                SaePoint saePoint = LocationClientService.getLocation(id);
                showPoint(saePoint);
            }
             if (currentaction == MainMenu.POSITIONS){
                 System.out.println("Bitte geben Sie die ID des Transmitters ein: ");
                 int id = in.nextInt();
                 showPoints(LocationClientService.getLocations(id));
             }
             if (currentaction == MainMenu.ALL_POSITIONS){
                 showAllPoints(LocationClientService.getAllLocations());
             }
             currentaction = showMenu();
        }
    }

    public static void showPoint(SaePoint saePoint){
        System.out.printf("%-11s|%-17s|%-17s|%-5s|%-3s%n", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-11s|%-17f|%-17f|%-5d|%-3d%n", saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix());
        }

    public static void showPoints(ArrayList<SaePoint> saePoints){
        System.out.printf("%-11s|%-17s|%-17s|%-5s|%-3s%n", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------");
        for (SaePoint point : saePoints) {
            System.out.printf("%-11s|%-17f|%-17f|%-5d|%-3d%n", point.getTime(), point.getLatitude(), point.getLongitude(), point.getNumberOfSatelites(), point.getFix());
        }
    }

    public static void showAllPoints(Hashtable<Integer,ArrayList<SaePoint>> saePoints){
        System.out.printf("%-3s|%-11s|%-17s|%-17s|%-5s|%-3s%n", "id", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------");
        for (Map.Entry<Integer,ArrayList<SaePoint>> entry : saePoints.entrySet()) {
            for (SaePoint saePoint : entry.getValue()) {
                System.out.printf("%-3s|%-11s|%-17f|%-17f|%-5d|%-3d%n", entry.getKey(), saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix());
            }
        }

    }

}
