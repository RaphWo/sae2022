package at.ac.fhwn.sae.lesson6.location.client;

import at.ac.fhwn.sae.lesson4.SaePoint;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class LocationClientService {
    private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
    private static final String REQUEST_METHOD_GET_LOCATION = "/getLocation";
    private static final String REQUEST_METHOD_GET_LOCATIONS = "/getLocations";
    private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/getAllLocations";
    private static final String BASE_URL = "https://location-server-wolf-location-app-api.azuremicroservices.io";

    public static SaePoint sendLocation(SaePoint pointToSend){
        String url = BASE_URL + REQUEST_METHOD_SET_LOCATION + "?id=1&lat=" + pointToSend.getLatitude() + "&lon=" + pointToSend.getLongitude() + "&time=" + pointToSend.getTime() + "&satNr=" + pointToSend.getNumberOfSatelites() + "&fixQ=" + pointToSend.getFix();
        try {
            System.out.println(url);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            System.out.println(scanner.nextLine());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pointToSend;
    }

    public static SaePoint getLocation(int id){
        String url = BASE_URL + REQUEST_METHOD_GET_LOCATION + "?id=1";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            String json = getResponseString(connection.getInputStream());
            SaePoint jsonPoint = new ObjectMapper().readValue(json, SaePoint.class);
            return jsonPoint;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<SaePoint> getLocations(int id){
        String url = BASE_URL + REQUEST_METHOD_GET_LOCATIONS + "?id=1";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            String json = getResponseString(connection.getInputStream());
            ArrayList<SaePoint> jsonArrayList = new ObjectMapper().readValue(json, new TypeReference<ArrayList<SaePoint>>(){});
            return jsonArrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Hashtable<Integer,ArrayList<SaePoint>> getAllLocations(){
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL + REQUEST_METHOD_GET_ALL_LOCATIONS).openConnection();
            String json = getResponseString(connection.getInputStream());
            Hashtable<Integer,ArrayList<SaePoint>> jsonHashtable = new ObjectMapper().readValue(json, new TypeReference<Hashtable<Integer,ArrayList<SaePoint>>>(){});
            return jsonHashtable;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getResponseString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()){
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }

}
