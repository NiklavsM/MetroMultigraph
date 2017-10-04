import java.util.HashSet;
import java.util.Set;

public class Station implements INode {
    private Set<String> stationColors = new HashSet<>();
    private int id;
    private String name;

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Station(int id) {
        this.id = id;
    }

    public void addColor(String color) {
        stationColors.add(color);
    }

    public boolean hasColor(String color) {
        return stationColors.contains(color);
    }

    public Set<String> getStationColors() {
        return stationColors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
