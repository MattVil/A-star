package test;

import java.awt.Color;
import java.util.ArrayList;

import algorithm.PathFounder;
import gui.GUImap;
import map.Map;
import map.Node;

public class Test {
	public static void main(String[] args) {
		Map map = new Map(10);
		map.addObstacle(4, 5);
		map.addObstacle(4, 6);
		map.addObstacle(3, 6);
		map.addObstacle(2, 6);
		map.addObstacle(4, 4);
		map.addObstacle(4, 3);
		map.addObstacle(4, 2);
		//map.addObstacle(1, 6);
		map.addObstacle(0, 6);
		//map.addObstacle(4, 1);
		map.addObstacle(4, 0);
		PathFounder pf = new PathFounder(map);
		
		Node start = map.getNode(3, 5);
		Node goal = map.getNode(9, 7);
		
		ArrayList<Node> result = pf.getPath(start, goal);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).toString() + " -> ");
		}
		
		
		GUImap gui = new GUImap(map);
		gui.refreshMap();
		for (int i = 0; i < result.size(); i++) {
			gui.setCase(result.get(i).getCoord().getX(), result.get(i).getCoord().getY(), new Color(255,0,0));
		}
		gui.setCase(start.getCoord().getX(), start.getCoord().getY(), new Color(0,255,0));
		gui.setCase(goal.getCoord().getX(), goal.getCoord().getY(), new Color(0,0,255));
		
	}
}
