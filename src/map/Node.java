package map;

/**
 * 
 * @author matthieu
 *
 */
public class Node {

	private Coordinate coord;
	private int value;
	
	public Node(Coordinate coord, int value){
		this.coord = coord;
		this.value = value;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
