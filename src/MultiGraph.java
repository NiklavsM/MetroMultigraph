import java.util.*;

public class MultiGraph implements IMultiGraph {

    private List<IEdge> listOfEdges = new ArrayList<>(); // make it HashMap???
    private Map<Integer, INode> mapOfNodes = new HashMap<>();

    public void addEdge(IEdge edge) {
        listOfEdges.add(edge);
    }

    public void addNode(INode node) {
        mapOfNodes.put(node.getId(), node);
    }

    public INode getNodeById(int id) {
        return mapOfNodes.get(id);
    }

    public INode getNodeByName(String name) {

        for (INode node : mapOfNodes.values()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public Vector<INode> findShortestPath(INode from, INode to) {
        boolean[] visitedNodes = new boolean[mapOfNodes.size() + 1];
        HashMap<Integer, Vector<INode>> pathsToNodes = new HashMap<>();
        LinkedList<INode> nodesToVisit = new LinkedList<>();

        nodesToVisit.add(from);
        Vector<INode> vector = new Vector<>();
        vector.add(from);
        pathsToNodes.put(from.getId(), vector);
        while (nodesToVisit.peek() != null) {
            if (searchBSF(nodesToVisit.poll(), to, visitedNodes, pathsToNodes, nodesToVisit)) {
                break;
            }
        }
        return pathsToNodes.get(to.getId());
    }

    private boolean searchBSF(INode nodeFrom, INode nodeTo, boolean[] visitedNodes, HashMap<Integer, Vector<INode>> pathsToNodes, LinkedList<INode> nodesToVisit) {
        int nodeFromId = nodeFrom.getId();
        int nodeToId = nodeTo.getId();
        if (!visitedNodes[nodeFromId]) {
            if (nodeFromId == nodeToId) {
                return true;
            } else {
                visitedNodes[nodeFromId] = true;
                List<INode> adjacentNodes = findAdjacentNodes(nodeFrom);
                for (INode node : adjacentNodes) {
                    if (pathsToNodes.get(node.getId()) == null) {
                        Vector<INode> vector = new Vector(pathsToNodes.get(nodeFromId));
                        vector.add(node);
                        pathsToNodes.put(node.getId(), vector);
                        nodesToVisit.add(node);
                    }
                }
            }
        }
        return false;
    }

    private List<INode> findAdjacentNodes(INode nodeFrom) {
        List<INode> nodesFromNode = new ArrayList<>();
        for (IEdge edge : listOfEdges) {
            if (edge.getFromNode().getId() == nodeFrom.getId()) {
                nodesFromNode.add(edge.getToNode());
            }
            if (edge.getToNode().getId() == nodeFrom.getId()) {
                nodesFromNode.add(edge.getFromNode());
            }
        }
        return nodesFromNode;
    }
}
