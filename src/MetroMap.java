import java.util.Vector;

public class MetroMap {
    private IMultiGraph metroSystem = new MultiGraph();

    public void addStation(int id, String name) {
        Station station = getStationById(id);
        if (station == null) {
            Station stationToAdd = new Station(id, name);
            metroSystem.addNode(stationToAdd);
        } else {
            station.setName(name);
        }
    }

    public void addLink(String linkColor, int fromId, int toId) {
        Station stationFrom = getStationById(fromId);
        Station stationTo = getStationById(toId);
        if (stationFrom == null) {
            stationFrom = new Station(fromId);
            metroSystem.addNode(stationFrom);
        }
        if (stationTo == null) {
            stationTo = new Station(toId);
            metroSystem.addNode(stationTo);
        }
        stationTo.addColor(linkColor);
        stationFrom.addColor(linkColor);
        MetroLink link = new MetroLink(linkColor, getStationById(fromId), getStationById(toId)); // Ask which is better MetroLink or IEdge
        metroSystem.addEdge(link);
    }

    public void findBestRoute(String from, String to) {
        INode stationFrom = getStationById(new Integer(from));
        INode stationTo = getStationById(new Integer(to));

        printRoute(metroSystem.findShortestPath(stationFrom, stationTo));
    }

    public void printRoute(Vector<INode> stations) {
        String colorYoureOn = "";
        System.out.println("Station from: " + stations.get(0).getName());
        for (int i = 0; i < stations.size() - 2; i++) {

            Station currentStation = getStationById(stations.get(i).getId());
            if (colorYoureOn == "") {
                colorYoureOn = currentStation.getStationColors().iterator().next();
            }
            Station nextStation = getStationById(stations.get(i + 1).getId());
            Station stationAfterNextStation = getStationById(stations.get(i + 2).getId());
            if (needToChangeLine(colorYoureOn, stationAfterNextStation)) {
                colorYoureOn = findCommonColor(nextStation, stationAfterNextStation);
                System.out.println("Change line at: \"" + nextStation.getName() + "\" switch to " + colorYoureOn + " line.");
            } else {
                System.out.println(" " + nextStation.getName());
            }
        }
        System.out.println("Station to: " + stations.get(stations.size() - 1).getName());
    }

    private String findCommonColor(Station stationOne, Station stationTwo) {
        for (String colorOne : stationOne.getStationColors()) {
            for (String colorTwo : stationTwo.getStationColors()) {
                if (colorOne.equals(colorTwo)) {
                    return colorOne;
                }
            }
        }
        return "";
    }

    private boolean needToChangeLine(String currentColor, Station stationAfterNextStation) {
        if (stationAfterNextStation.hasColor(currentColor)) {
            return false;
        } else return true;

    }

//    public void printRoute(String[] route) { // Should tidy this up, maybe even seperate class for user inteface stuff NMS
//        boolean needToChangeLine = true;
//        String currentColor = " ";
//        int routeLength = route.length;
//        for (int i = 0; i < routeLength - 2; i++) {
//          //  System.out.println(Arrays.toString(route));
//            Station station = getStationById(new Integer(route[i]));
//            if (i == 0) {
//                System.out.println("Your path: " + getStationNameById(new Integer(route[i])));
//            }
//            Station nextStation = getStationById(new Integer(route[i + 2]));
//            for (String color : nextStation.getStationColors()) {
//                if (station.hasColor(color)) {
//                    currentColor = color;
//                    needToChangeLine = false;
//                    break;
//                } else {
//                    currentColor = color;
//                }
//            }
//            if (needToChangeLine) {
//                System.out.println("Change lines at " + route[i + 1] + "-" + getStationNameById(new Integer(route[i + 1])) + " Switch to " + currentColor + " line.");
//            } else
//                System.out.println("  " + route[i + 1] + "-" + getStationNameById(new Integer(route[i + 1])) + " " + currentColor);
//
//                needToChangeLine = true;
//
//
//        }
//        System.out.println("Destination: " + getStationNameById(new Integer(route[routeLength - 1])) + " " + currentColor);
//    }

    private Station getStationById(int id) {
        return (Station) metroSystem.getNodeById(id);
    }

    private Station getStationByName(String name) {
        return (Station) metroSystem.getNodeByName(name);
    }

}
