
public class Link implements IEdge {
    private Station fromNode;
    private Station toNode;

    public Link(Station stationFrom, Station stationTo) {
        this.fromNode = stationFrom;
        this.toNode = stationTo;
    }


    public Station getFromNode() {
        return fromNode;
    }

    public Station getToNode() {
        return toNode;
    }
}
