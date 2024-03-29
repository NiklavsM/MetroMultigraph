import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MetroUserInterface {
    private MetroMap metroMap;
    private Scanner inputScanner = new Scanner(System.in);
    private int stationFromId;
    private int stationToId;

    public MetroUserInterface(MetroMap metroMap) {
        this.metroMap = metroMap;
        startText();
        runUserInterface();
    }


    private void runUserInterface() {
        getStationFrom();
        getStationTo();
        System.out.println();
        findBestRoute();
        System.out.println();
        runUserInterface();
    }

    private void startText() {
        System.out.println("Welcome to the MetroApp");
    }

    private void getStationFrom() {
        List<Station> stations;
        System.out.println("Please type in the station from");
        String stationFrom = inputScanner.nextLine().toLowerCase();
        stations = metroMap.getStationsByName(stationFrom);

        if(stationFrom.contains("exit")){
            System.out.println("Program ending.");
            System.exit(1);
        }

        if (stations.size() == 0) {
            System.out.println(stationFrom + " does not exist, please type in existing station");
            getStationFrom();
        } else if (stations.size() == 1) {
            stationFromId = stations.get(0).getId();
        } else {
            System.out.println("There are more than one station with this name, please type in the right stations id");
            for (Station station : stations) {
                System.out.println(station.getName() + " With stations id: " + station.getId() + " on line " + station.getStationColors().iterator().next());
            }
            stationFrom = inputScanner.nextLine();
            if (stationFrom.matches("\\d+")) {
                stationFromId = new Integer(stationFrom);
                if (metroMap.getStationById(stationFromId)== null){
                    getStationFrom();
                }
            } else getStationFrom();
        }
    }

    private void getStationTo() {
        List<Station> stations;
        System.out.println("Please type in the station to");
        String stationTo = inputScanner.nextLine().toLowerCase();
        stations = metroMap.getStationsByName(stationTo);

        if(stationTo.contains("exit")){
            System.out.println("Program ending.");
            System.exit(1);
        }

        if (stations.size() == 0) {
            System.out.println(stationTo + " does not exist, please type in existing station");
            getStationTo();
        } else if (stations.size() == 1) {
            stationToId = stations.get(0).getId();
        } else {
            System.out.println("There are more than one station with this name, please type in the right stations id");
            for (Station station : stations) {
                System.out.println(station.getName() + " With stations id: " + station.getId() + " on line " + station.getStationColors().iterator().next());
            }
            stationTo = inputScanner.nextLine();
            if (stationTo.matches("\\d+")) {
                stationToId = new Integer(stationTo);
                if (metroMap.getStationById(stationToId)== null){
                    getStationTo();
                }
            } else getStationTo();
        }
    }

    private void findBestRoute() {
        metroMap.findBestRoute(stationFromId, stationToId);
    }

}