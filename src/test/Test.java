package test;

import gui.GUImap;
import map.Map;

public class Test {
	public static void main(String[] args) {
		Map map = new Map(10);
		map.addObstacle(4, 5);
		GUImap gui = new GUImap(map);
		gui.refreshMap();
	}
}
