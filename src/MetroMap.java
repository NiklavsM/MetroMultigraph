import java.util.Vector;

public class MetroMap {
    private IMultiGraph metroSystem = new MultiGraph();

    public void addStation(int id, String name) {
        Station station = getStationById(id);
        if (station == null) {
            Station stationToAdd = new Station(id, name);
            metroSystem.addNode(stationToAdd);
            //stations.add(station);}
        } else {
            station.setName(name);
        }
    }

    public void addLink(String linkColor, int fromId, int toId) {
        Station stationFrom = getStationById(fromId);
        Station stationTo = getStationById(toId);
        if (stationFrom == null) {
            Station stationToAdd = new Station(fromId);
            stationToAdd.addColor(linkColor);
            metroSystem.addNode(stationToAdd);
        }
        if (stationTo == null) {
            Station stationToAdd = new Station(toId);
            stationToAdd.addColor(linkColor);
            metroSystem.addNode(stationToAdd);
        }
        MetroLink link = new MetroLink(linkColor, getStationById(fromId), getStationById(toId)); // Ask which is better MetroLink or IEdge
        metroSystem.addEdge(link);
    }

    public void findBestRoute(String from, String to) {
        Station stationFrom = getStationById(new Integer(from));
        Station stationTo = getStationById(new Integer(to));
//        INode stationFrom = new Station(from);
//        INode stationTo = new Station(to);

       // String[] route = metroSystem.findShortestPath(stationFrom, stationTo);
        //Vector<Station> stations = (Vector<Station>)metroSystem.findShortestPath(stationFrom, stationTo);
       // printRoute(stations);
    }
//    public void printRoute(Vector<?> stations){
//        System.out.println(station.toString());
//        for(Station station : stations){
//            Station nodeTemp = (Station)node;
//            System.out.println(nodeTemp.getName());
//        }
//    }

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
