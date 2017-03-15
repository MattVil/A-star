package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import map.Map;

/**
 * 
 * @author matthieu
 *
 */
public class GUImap extends JPanel{
	
	private Map map;
	private int GRID_SIZE;
	private Cell[][] jmap;
	
	public GUImap(Map map){
		setPreferredSize(new Dimension(800, 800));
        
        this.map = map;
        GRID_SIZE = map.getSize();
        jmap = new Cell[GRID_SIZE][GRID_SIZE];
        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        this.initMap();
	}
	
	public void initMap(){
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				Cell cell = new Cell(i, j);
				
                add(cell);
                MouseListener ml = new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        
                        int buttonDown = e.getButton();
                        
                        if (buttonDown == MouseEvent.BUTTON1) {
                        	click(e, cell);
                        } else if(buttonDown == MouseEvent.BUTTON2) {
                        	middleClick(e, cell);
                        } else if(buttonDown == MouseEvent.BUTTON3) {
                        	rightClick(e, cell);
                        }
                    }
					public void mousePressed(MouseEvent e) {

					}
					public void mouseReleased(MouseEvent e) {
	
					}
					public void mouseEntered(MouseEvent e) {
	
					}
					public void mouseExited(MouseEvent e) {

					}
                };
                cell.addMouseListener(ml);
                jmap[i][j] = cell;
                add(jmap[i][j]);
			}
		}
	}
	
	public void setCase(int x, int y, Color color){
		jmap[x][y].setBackground(color);
	}
	
	public void refreshMap(){
		for(int i=0; i<GRID_SIZE; i++){
			for(int j=0; j<GRID_SIZE; j++){
				if(map.getNode(i, j).getType() == 0){
					jmap[i][j].setBackground(new Color(223,242,255));
				}
				else if(map.getNode(i, j).getType() == 1){
					jmap[i][j].setBackground(new Color(150,150,150));
				}
				else if(map.getNode(i, j).getType() == 2){
					jmap[i][j].setBackground(new Color(0,250,0));
				}
				else if(map.getNode(i, j).getType() == 3){
					jmap[i][j].setBackground(new Color(0,0,250));
				}
				else if(map.getNode(i, j).getType() == 4){
					jmap[i][j].setBackground(new Color(250,0,0));
				}
				
			}
		}
	}
	
	public void click(MouseEvent e, Cell cell) {
	   	//System.out.println(cell.getX()+";"+cell.getY());
	    int y = (cell.getX())*GRID_SIZE/600;
		int x = (cell.getY())*GRID_SIZE/600;	
		if(map.getNode(x, y).getType() == 0)
			map.addObstacle(x, y);
		else
			map.getNode(x, y).setType(0);
		refreshMap();
	}
	
	public void rightClick(MouseEvent e, Cell cell) {
	   	//System.out.println(cell.getX()+";"+cell.getY());
	    int y = (cell.getX())*GRID_SIZE/600;
		int x = (cell.getY())*GRID_SIZE/600;	
		if(map.getNode(x, y).getType() == 0)
			map.addStart(x, y);
		else
			map.getNode(x, y).setType(0);
		refreshMap();
	}
	
	public void middleClick(MouseEvent e, Cell cell) {
	   	//System.out.println(cell.getX()+";"+cell.getY());
	    int y = (cell.getX())*GRID_SIZE/600;
		int x = (cell.getY())*GRID_SIZE/600;	
		if(map.getNode(x, y).getType() == 0)
			map.addGoal(x, y);
		else
			map.getNode(x, y).setType(0);
		refreshMap();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Cell[][] getJmap() {
		return jmap;
	}

	public void setJmap(Cell[][] jmap) {
		this.jmap = jmap;
	}
}
