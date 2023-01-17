package at.ac.fhwn.sae.lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NmeaReaderAplikation {

    private File nmeaFile;

    private Scanner scanner;

    public NmeaReaderAplikation(File nmeaFile) {
        try {
            assert nmeaFile.exists();
            FileInputStream fis = new FileInputStream(nmeaFile);
            this.scanner = new Scanner(fis);
            this.nmeaFile = nmeaFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = null;
        System.out.println("Welche Datei soll geladen werden?");
        System.out.printf("%-3s%-10s%n", "1.", "auto.txt");
        System.out.printf("%-3s%-10s%n", "2.", "auto2.txt");
        System.out.printf("%-3s%-10s%n", "3.", "nmea.txt");
        Scanner chooseFile = new Scanner(System.in);
        switch (chooseFile.nextInt()) {
            case 1:
                file = new File(NmeaReaderAplikation.class.getClassLoader().getResource("auto.txt").getFile());
                break;
            case 2:
                file = new File(NmeaReaderAplikation.class.getClassLoader().getResource("auto2.txt").getFile());
                break;
            case 3:
                file = new File(NmeaReaderAplikation.class.getClassLoader().getResource("nmea.txt").getFile());
                break;
        }
        System.out.println("Name: " + file.getName());
        System.out.println("Exists: " + file.exists());
        System.out.println("Can read: " + file.canRead());
        Thread.sleep(500);
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);

        List<SaePoint> nmea = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] components = scanner.nextLine().split(",");
            if (components[0].equals("$GNGGA")) {
                // min / 60 = Grad
                double lat = Double.parseDouble(components[2].substring(0, 2)) + Double.parseDouble(components[2].substring(2)) / 60;
                double lon = Double.parseDouble(components[4].substring(0, 3)) + Double.parseDouble(components[4].substring(3)) / 60;
                if (components[3].equals("S")) {
                    lat = lat * -1;
                }
                if (components[5].equals("W")) {
                    lon = lon * -1;
                }
                nmea.add(new SaePoint(components[1], lat, lon, Integer.parseInt(components[7]), Integer.parseInt(components[6])));
            }
        }
        System.out.printf("%-11s|%-17s|%-17s|%-5s|%-3s%n", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------");
        for (SaePoint point : nmea) {
            System.out.printf("%-11s|%-17f|%-17f|%-5d|%-3d%n", point.time, point.latitude, point.longitude, point.numberOfSatelites, point.fix);
        }
    }

    public SaePoint readPoint() {
        SaePoint saePoint = null;
        while (this.scanner.hasNextLine()) {
            String[] components = this.scanner.nextLine().split(",");
            if (components[0].equals("$GNGGA")) {
                // min / 60 = Grad
                double lat = Double.parseDouble(components[2].substring(0, 2)) + Double.parseDouble(components[2].substring(2)) / 60;
                double lon = Double.parseDouble(components[4].substring(0, 3)) + Double.parseDouble(components[4].substring(3)) / 60;
                if (components[3].equals("S")) {
                    lat = lat * -1;
                }
                if (components[5].equals("W")) {
                    lon = lon * -1;
                }
                return new SaePoint(components[1], lat, lon, Integer.parseInt(components[7]), Integer.parseInt(components[6]));
            }
        }
        if(!scanner.hasNextLine()){
            try {
                assert nmeaFile.exists();
                FileInputStream fis = new FileInputStream(nmeaFile);
                this.scanner = new Scanner(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return this.readPoint();
        }
        return saePoint;
    }
}