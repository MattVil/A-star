package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import map.Map;
import map.Node;

/**
 * 
 * @author matthieu
 *
 */
public class PathFounder {

	private Map map;
	private int size;
	private LinkedList<Node> openList;
	private LinkedList<Node> closeList;
	
	public PathFounder(Map map){
		openList = new LinkedList<Node>();
		closeList = new LinkedList<Node>();
		this.map = map;
		this.size = map.getSize();
	}
	
	public LinkedList<Node> getPath(Node begin, Node end){
		
		calculValue(begin, end);
		openList.add(begin);
		Node currentNode = begin;
		
		//ListIterator<Node> li = openList.listIterator();
		
		while(!openList.isEmpty()){
			ArrayList<Node> neighbors = getViableNeighbour(currentNode);
			for (int i = 0; i < neighbors.size(); i++) {
				calculValue(neighbors.get(i), end);
			}
		}
		
		return closeList;
	}
	
	/**
	 * this methode set the value of current by compuiting the distance with the goal
	 * @param current
	 * @param goal
	 */
	public void calculValue(Node current, Node goal){
		current.setValue(Math.pow((goal.getCoord().getX()-current.getCoord().getX()), 2) + Math.pow((goal.getCoord().getY()-current.getCoord().getY()), 2));
	}
	
	
	/**
	 * This methode return the list of current's neighbour nodes witch can be evaluate
	 * @param current
	 * @return list of node
	 */
	public ArrayList<Node> getViableNeighbour(Node current){
		
		int currentX = current.getCoord().getX();
		int currentY = current.getCoord().getY();
		
		ArrayList<Node> result = new ArrayList<Node>();
		

		if(map.validCoord(currentX, currentY+1)){
			result.add(map.getNode(currentX, currentY+1));
		}

		if(map.validCoord(currentX, currentY-1)){
			result.add(map.getNode(currentX, currentY-1));
		}

		if(map.validCoord(currentX+1, currentY)){
			result.add(map.getNode(currentX+1, currentY));
		}
		
		if(map.validCoord(currentX-1, currentY)){
			result.add(map.getNode(currentX-1, currentY));
		}
		
		for (int i = 0; i < result.size(); i++) {
			if(result.get(i).getType() != 0)
				result.remove(i);
		}
		
		return result;
	}
	
	public boolean isInCloseList(Node node){
		for (int i = 0; i < closeList.size(); i++) {
			if(closeList.get(i).equals(node))
				return true;
		}
		return false;
	}
	
	public boolean isInOpenList(Node node){
		for (int i = 0; i < openList.size(); i++) {
			if(openList.get(i).equals(node))
				return true;
		}
		return false;
	}
}
