import java.util.HashSet;
import java.util.Set;

public class Station extends Node{
	private Set<String> stationColors = new HashSet<>();
	public Station(int id, String name) {
		super(id, name);
	}
	public void addColor(String color){
		stationColors.add(color);
	}
	public boolean hasColor(String color){
		return stationColors.contains(color);
	}
	public Set<String> getStationColors(){
		return stationColors;
	}

}
