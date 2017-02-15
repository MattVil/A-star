package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import map.Map;

/**
 * 
 * @author matthieu
 *
 */
public class GUImap extends JFrame{

	private Map mapStructure;
	private int size;
	
	private JPanel fond = new JPanel();
	
	private JPanel mapPart = new JPanel();
	private JPanel settingPart = new JPanel();

	private JPanel[][] map;
	
	public GUImap(Map map){
		this.mapStructure = map;
		this.size = map.getSize();
		
		this.getContentPane().add(fond);
		
		this.map = new JPanel[size][size];
		
		initLayout();
		initMapPart();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 600);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initLayout(){
		fond.setLayout(new GridLayout(1, 2));
		fond.add(mapPart);
		fond.add(settingPart);
		mapPart.setLayout(new GridLayout(size, size));
		settingPart.setLayout(new BoxLayout(settingPart, BoxLayout.PAGE_AXIS));
	}
	
	public void initMapPart(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				JPanel p = new JPanel();
				p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				p.add(new JLabel("[" + i + "," + j + "]", JLabel.CENTER));
				
				map[i][j] = p;
				mapPart.add(map[i][j]);
			}
		}
	}
	
	public void refreshMap(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(mapStructure.getNode(i, j).getType() == 0){
					map[i][j].setBackground(new Color(223,242,255));
				}
				else if(mapStructure.getNode(i, j).getType() == 1){
					map[i][j].setBackground(new Color(150,150,150));
				}
			}
		}
	}
}
