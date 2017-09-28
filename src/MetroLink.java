
public class MetroLink implements IEdge {
	private String linkColor;
	private INode fromNode;
	private INode toNode;
	public MetroLink(String linkColor, INode stationFrom, INode stationTo) {
		this.linkColor = linkColor;
		this.fromNode = stationFrom;
		this.toNode = stationTo;
	}
	public String getName(){
		return linkColor;
	}

    public INode getFromNode() {
        return fromNode;
    }
    public INode getToNode() {
        return toNode;
    }
}
