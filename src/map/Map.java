package map;

/**
 * 
 * @author matthieu
 *
 */
public class Map {
	 /**
	  * 0 - empty case
	  * 1 - full case - obstacle
	  */
	private Node[][] map;
	private int size;
	
	public Map(int size){
		this.size = size;
		map = new Node[size][size];
		initMap();
	}
	
	public void initMap(){
		for(int i=0; i<size; i++){
			for (int j = 0; j < size; j++) {
				map[i][j] = new Node(new Coordinate(i,j), 0);
			}
		}
	}
	
	
	/**
	 * this methode add obstacle on the map
	 * @param x
	 * @param y
	 */
	public void addObstacle(int x, int y){
		if(validCoord(x, y)){
			map[x][y].setType(1);;
		}
	}
	
	/**
	 * this methode check if the coord (x,y) is in the map
	 * @param x
	 * @param y
	 * @return true if the coord is valid, false if not
	 */
	public boolean validCoord(int x, int y){
		if(x>=0 && x<size){
			if(y>=0 && y<size)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Node getNode(int x, int y){
		if(x<size && x>=0){
			if(y<size && y>=0)
				return map[x][y];
			else
				return null;
		}
		else
			return null;
	}

	public Node[][] getMap() {
		return map;
	}

	public void setMap(Node[][] map) {
		this.map = map;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
