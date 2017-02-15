package test;

import java.util.ArrayList;

import algorithm.PathFounder;
import gui.GUImap;
import map.Map;
import map.Node;

public class Test {
	public static void main(String[] args) {
		Map map = new Map(10);
		map.addObstacle(4, 5);
		PathFounder pf = new PathFounder(map);
		
		Node start = map.getNode(3, 5);
		Node goal = map.getNode(9, 7);
		
		
		
		GUImap gui = new GUImap(map);
		gui.refreshMap();
	}
}
