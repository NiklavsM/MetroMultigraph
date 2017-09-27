
public class Node {

	private int id;
	private String name;
	
	public Node(int id, String name){ // could make another without name
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
