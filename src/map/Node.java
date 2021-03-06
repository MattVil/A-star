package map;

/**
 * 
 * @author matthieu
 *
 */
public class Node {

	private Coordinate coord;
	private int type;
	private double value;
	private Node previous;
	
	public Node(Coordinate coord, int type){
		this.coord = coord;
		this.type = type;
		this.value = 0;
	}
	public Node(){
		
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public String toString(){
		return type + " : " + coord.toString() + " - " + value;
	}
}
