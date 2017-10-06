import java.util.ArrayList;
import java.util.List;

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
        Link link = new Link(getStationById(fromId), getStationById(toId));
        metroSystem.addEdge(link);
    }

    public void findBestRoute(int from, int to) {
        INode stationFrom = getStationById(from);
        INode stationTo = getStationById(to);

        printRoute(metroSystem.findShortestPath(stationFrom, stationTo));
    }

    private void printRoute(List<INode> stations) {
        String currentColor = "";
        for (int i = 0; i < stations.size() - 2; i++) {

            Station currentStation = getStationById(stations.get(i).getId());
            if (currentColor.equals("")) {
                currentColor = currentStation.getStationColors().iterator().next();
                System.out.println("At the " + currentStation.getName() + " station get on " + currentColor + " line to the direction of " + getStationById(stations.get(i + 1).getId()).getName());
            }
            Station nextStation = getStationById(stations.get(i + 1).getId());
            Station stationAfterNextStation = getStationById(stations.get(i + 2).getId());
            if (!stationAfterNextStation.hasColor(currentColor)) {
                currentColor = findCommonColor(nextStation, stationAfterNextStation);
                System.out.println("Change line at: \"" + nextStation.getName() + "\" switch to " + currentColor + " line to the direction of " + getStationById(stations.get(i + 1).getId()).getName());
            }
        }
        System.out.println("You have reached: " + stations.get(stations.size() - 1).getName());
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

    private Station getStationById(int id) {
        return (Station) metroSystem.getNodeById(id);
    }

    public List<Station> getStationsByName(String name) {
        List<Station> stationsWithName = new ArrayList<>();
        metroSystem.getNodesByName(name).forEach(station -> stationsWithName.add((Station) station));
        return stationsWithName;
    }
}
