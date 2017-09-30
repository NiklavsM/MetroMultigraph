import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface IMultiGraph {
	public void addNode(INode node);
	public void addEdge(IEdge edge);
	public Vector<INode> findShortestPath(INode from, INode to);
	public INode getNodeById(int id);
	public INode getNodeByName(String name);
}
