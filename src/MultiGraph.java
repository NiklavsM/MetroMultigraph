import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MultiGraph implements IGraph { // Maybe graph could hold node ids..

	private ArrayList<Edge> listOfEdges = new ArrayList<>(); // make it HashSet
	private ArrayList<Node> listOfNodes = new ArrayList<Node>();// make it HashSet

	public void addEdge(Edge edge){
		listOfEdges.add(edge);
	}

	public void addNode(int id, String name) {
		listOfNodes.add(new Node(id, name));		
	}

	public Node getNodeById(int id){
		for(Node node : listOfNodes){
			if(node.getId() == id){
				return node;
			}
		}
		return null;
	}

	public Node getNodeByName(String name){
		for(Node node : listOfNodes){
			if(node.getName().equals(name)){
				return node;
			}
		}
		return null;
	}

	public String[] findShortestPath(int from, int to){
		boolean[] visitedNodes = new boolean[listOfNodes.size()+1];
		String[] pathsToNodes = new String[listOfNodes.size()+1];
		LinkedList<Integer> nodesToVisit = new LinkedList<Integer>();

		nodesToVisit.add(from);
		pathsToNodes[from] = from + " ";
		while(nodesToVisit.peek() != null) {
			if(searchBSF(nodesToVisit.poll(), to, visitedNodes, pathsToNodes, nodesToVisit)){
				break;
			};
		}
		return pathsToNodes[to].split(" ");
	}

	private boolean searchBSF(int from, int to, boolean[] visitedNodes, String[] pathsToNodes, LinkedList<Integer> nodesToVisit){
		if(!visitedNodes[from]){
			if(from == to){
				return true;
			}
			else {
				//System.out.println("HERE 2");
				visitedNodes[from] = true;
				ArrayList<Integer> adjacentNodes = findAdjacentNodes(from);
				for(Integer node : adjacentNodes){
					//System.out.println(Arrays.toString(pathsToNodes));
					if(pathsToNodes[node] == null){
					pathsToNodes[node] = pathsToNodes[from] + node + " ";
					nodesToVisit.add(node);
					}
				}
			}
		}
		return false;
	}

	private ArrayList<Integer> findAdjacentNodes(int from){
		ArrayList<Integer> nodesFromNode = new ArrayList<Integer>();
		for (Edge edge : listOfEdges){
			if(edge.getFromNodeId() == from){
				nodesFromNode.add(edge.getToNodeId());
			}
			if(edge.getToNodeId() == from){
				nodesFromNode.add(edge.getFromNodeId());
			}
		}
		return nodesFromNode;
	}

	public ArrayList<Edge> getListOfEdges(){
		return listOfEdges;
	}
}
