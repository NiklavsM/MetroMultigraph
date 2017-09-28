import java.util.*;

public class MultiGraph implements IMultiGraph { // Maybe graph could hold node ids..

    private List<IEdge> listOfEdges = new ArrayList<>(); // make it HashSet
    private List<INode> listOfNodes = new ArrayList<>();// make it HashSet

    public void addEdge(IEdge edge) {
        listOfEdges.add(edge);
    }

    public void addNode(INode node) {
        listOfNodes.add(node);
    }

    public INode getNodeById(int id) {
        for (INode node : listOfNodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    public Vector<INode> findShortestPath(INode from, INode to) {
        boolean[] visitedNodes = new boolean[listOfNodes.size() + 1];
        HashMap<Integer, Vector<INode>> pathsToNodes = new HashMap<>();
        //String[] pathsToNodes = new String[listOfNodes.size()];
        LinkedList<INode> nodesToVisit = new LinkedList<>();

        nodesToVisit.add(from);
        //pathsToNodes[from.getId()] = from.getId() + " ";
        Vector<INode> vector = new Vector<>();
        vector.add(from);
        pathsToNodes.put(from.getId(), vector);
        while (nodesToVisit.peek() != null) {
            if (searchBSF(nodesToVisit.poll(), to, visitedNodes, pathsToNodes, nodesToVisit)) {
                break;
            }
        }
//        System.out.println(Arrays.toString(pathsToNodes[to.getId()].split(" ")));
//        String[]tempString = pathsToNodes[to.getId()].split(" ");

        // return pathsToNodes[to.getId()].split(" ");
        return pathsToNodes.get(to.getId());
    }

    private boolean searchBSF(INode nodeFrom, INode nodeTo, boolean[] visitedNodes, HashMap<Integer, Vector<INode>> pathsToNodes, LinkedList<INode> nodesToVisit) {
        int nodeFromId = nodeFrom.getId();
        int nodeToId = nodeTo.getId();
        if (!visitedNodes[nodeFromId]) {
            if (nodeFromId == nodeToId) {
                return true;
            } else {
                //System.out.println("HERE 2");
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
