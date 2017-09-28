import java.util.ArrayList;

public interface IGraph {
	public void addNode(int id, String name);
	public void addEdge(Edge edge);
	public String[] findShortestPath(int from, int to);
	public Node getNodeById(int id);
	public Node getNodeByName(String name);
	public ArrayList<Edge> getListOfEdges();
}
