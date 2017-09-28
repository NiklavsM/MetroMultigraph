import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MetroMap {
	private IGraph metroSystem = new MultiGraph();
	private ArrayList<Station> stations = new ArrayList<Station>();

	public void addStation(int id, String name){
		metroSystem.addNode(id,name);
		stations.add(new Station(id, name));
	}
	public void addLink(int linkId, int stationFrom, int stationTo, String lineColor){
		Edge link = new MetroLink(linkId, stationFrom,  stationTo, lineColor);
		metroSystem.addEdge(link);
	}
	public String getStationNameById(int id){
		return metroSystem.getNodeById(id).getName();
	}
	public void findBestRoute(String from, String to){
		Node stationFrom = metroSystem.getNodeByName(from);
		Node stationTo = metroSystem.getNodeByName(to);

		String [] route = metroSystem.findShortestPath(stationFrom.getId(), stationTo.getId());
		printRoute(route);
	}
	public void printRoute(String[] route) { // Should tidy this up, maybe even seperate class for user inteface stuff NMS
		boolean needToChangeLine = true;
		String currentColor = " ";
		int routeLength = route.length;
		for (int i = 0; i < routeLength - 2; i++) {
			Station station = getStationById(new Integer(route[i]));
			if (i == 0) {
				System.out.println("Your path: " + getStationNameById(new Integer(route[i])));
			}
			Station nextStation = getStationById(new Integer(route[i + 2]));
			for (String color : nextStation.getStationColors()) {
				if (station.hasColor(color)) {
					currentColor = color;
					needToChangeLine = false;
					break;
				} else {
					currentColor = color;
				}
			}
			if (needToChangeLine) {
				System.out.println("Change lines at " + route[i + 1] + "-" + getStationNameById(new Integer(route[i + 1])) + " Switch to " + currentColor + " line.");
			} else
				System.out.println("  " + route[i + 1] + "-" + getStationNameById(new Integer(route[i + 1])) + " " + currentColor);

			needToChangeLine = true;

		}
		System.out.println("Destination: " + getStationNameById(new Integer(route[routeLength - 1])) + " " + currentColor);
	}

	public Station getStationById(int id){
		for(Station station : stations){
			if(station.getId() == id){
				return station;
			}
		}
		return null;
	}

	public void finish(){
		ArrayList<Edge> links = metroSystem.getListOfEdges();
		for(Edge link : links){
			MetroLink metroLink = (MetroLink)link;// Could use generics to get rid of parsing NMS
			for(Station station : stations){
				if(metroLink.getToNodeId() == station.getId() || metroLink.getFromNodeId() == station.getId()){
					station.addColor(metroLink.getLineColor());
				}
			}
		}
	}
}
