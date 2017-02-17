package run;

import java.util.ArrayList;

import algorithm.PathFounder;
import gui.Window;
import map.Map;
import map.Node;

public class Run {

	private Window window;
	
	private Map map;
	
	private PathFounder pf;
	
	public Run(int sizeOfMap){
		map  = new Map(sizeOfMap);
		pf = new PathFounder(map);
		window = new Window(map);
	}
	
	public void run(){
		boolean found = false;
		while(!found){
			System.out.println(window.getStartStop());
			if(window.getStartStop()){
				window.getGmap().refreshMap();
				ArrayList<Node> result = pf.getPath(map.getStart(), map.getGoal());
				for (int i = 0; i < result.size(); i++) {
					result.get(i).setType(4);
					System.out.print(result.get(i).toString() + " -> ");
				}
				window.getGmap().refreshMap();
				found = true;
			}
		}
	}
}
