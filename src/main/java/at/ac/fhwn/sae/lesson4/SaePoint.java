package at.ac.fhwn.sae.lesson4;

public class SaePoint {
    String time;
    double latitude;
    double longitude;
    int numberOfSatelites;
    int fix;

    public SaePoint(){
    }

    public SaePoint(String time, double latitude, double longitude, int numberOfSatelites, int fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfSatelites = numberOfSatelites;
        this.fix = fix;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getFix() {
        return fix;
    }

    public int getNumberOfSatelites() {
        return numberOfSatelites;
    }

    public String getTime() {
        return time;
    }
}
