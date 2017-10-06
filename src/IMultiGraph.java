import java.util.List;

public interface IMultiGraph {
    void addNode(INode node);

    void addEdge(IEdge edge);

    List<INode> findShortestPath(INode from, INode to);

    INode getNodeById(int id);

    List<INode> getNodesByName(String name);

}
