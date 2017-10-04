
public class MetroLink implements IEdge {
    private String name;
    private Station fromNode;
    private Station toNode;

    public MetroLink(String linkColor, Station stationFrom, Station stationTo) {
        this.name = linkColor;
        this.fromNode = stationFrom;
        this.toNode = stationTo;
    }

    public String getName() {
        return name;
    }

    public Station getFromNode() {
        return fromNode;
    }

    public Station getToNode() {
        return toNode;
    }
}
