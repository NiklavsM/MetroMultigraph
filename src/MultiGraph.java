import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MultiGraph implements Graph { // Maybe graph could hold node ids..

	private ArrayList<Edge> listOfEdges = new ArrayList<>();
	private ArrayList<Node> listOfNodes = new ArrayList<Node>();

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

	public Edge getEdgeById(int id){
		for(Edge edge : listOfEdges){
			if(edge.getEdgeId() == id){
				return edge;
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
//		for(int i = 1;i<listOfNodes.size();i++){
//			if(pathsToNodes[i] != null){
//				System.out.println(pathsToNodes[i]);
				//String[] tempString1 = pathsToNodes[i].split(" ");
//				for(String temp : tempString1){
//					System.out.println("pathsToNodes \t " + temp + " " + getNodeById(new Integer(temp)).getName());
//				}
//			}
//		}
//		for(String temp : tempString){
//			System.out.println("pathsToNodes \t " + temp + " " + getNodeById(new Integer(temp)).getName());
//		}
//		//System.out.println("pathsToNodes  " + pathsToNodes[to]);

	}

	public boolean searchBSF(int from, int to, boolean[] visitedNodes, String[] pathsToNodes, LinkedList<Integer> nodesToVisit){
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

	public ArrayList<Integer> findAdjacentNodes(int from){
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
