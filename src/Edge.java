
public class Edge {
	
	int edgeId;
	int fromNodeId;
	int toNodeId;

	public Edge(int edgeId, int fromNodeId, int toNodeId){
		this.edgeId = edgeId;
		this.fromNodeId = fromNodeId;
		this.toNodeId = toNodeId;
	}
	
	public int getEdgeId() {
		return edgeId;
	}
	
	public int getFromNodeId() {
		return fromNodeId;
	}
	public int getToNodeId() {
		return toNodeId;
	}
}
