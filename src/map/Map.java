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
	  * 2 - start
	  * 3 - goal
	  * 4 - path
	  */
	private Node[][] map;
	private int size;
	
	private Node start;
	private Node goal;
	
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
			map[x][y].setType(1);
		}
	}
	
	/**
	 * this methode add a start point on the map
	 * @param x
	 * @param y
	 */
	public void addStart(int x, int y){
		if(validCoord(x, y)){
			map[x][y].setType(2);
			start = map[x][y];
		}
	}
	
	/**
	 * this methode add a goal ppint on the map
	 * @param x
	 * @param y
	 */
	public void addGoal(int x, int y){
		if(validCoord(x, y))
			map[x][y].setType(3);
			goal = map[x][y];
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

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getGoal() {
		return goal;
	}

	public void setGoal(Node goal) {
		this.goal = goal;
	}
}
