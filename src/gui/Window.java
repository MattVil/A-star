package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import map.Map;

public class Window extends JFrame{
	
	private JPanel fond = new JPanel();
	
	private GUImap gmap;
	private JPanel settingPart;
	
	private Boolean startStop;
	JButton startStopButton = new JButton("START");
	
	private JTextField goalTextFieldX;
	private JTextField goalTextFieldY;
	private JButton goalButton = new JButton("ADD");
	
	private JTextField startTextFieldX;
	private JTextField startTextFieldY;
	private JButton startButton = new JButton("ADD");
	
	public Window(Map map){
		
		gmap = new GUImap(map);
		settingPart = new JPanel();
		
		startStop = false;
		
		initLayout();
		initSettingPart();
		
		this.getContentPane().add(fond);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initLayout(){
		fond.setLayout(new GridLayout(1, 2));
		settingPart.setLayout(new BoxLayout(settingPart, BoxLayout.PAGE_AXIS));
		fond.add(gmap);
		fond.add(settingPart);
	}
	
	public void initSettingPart(){
		startStopButton.addActionListener(new ActionStartStop());
		settingPart.add(startStopButton);
		
		JPanel startPart = new JPanel();
		startPart.setLayout(new FlowLayout());
		startPart.add(new JLabel("START : "));
		startTextFieldX = new JTextField();
		startTextFieldX.setPreferredSize(new Dimension(40,20));;
		startTextFieldY = new JTextField();
		startTextFieldY.setPreferredSize(new Dimension(40,20));;
		startPart.add(startTextFieldX);
		startPart.add(startTextFieldY);
		startButton.addActionListener(new ActionAddStart());
		startPart.add(startButton);
		settingPart.add(startPart);
		
		JPanel goalPart = new JPanel();
		goalPart.setLayout(new FlowLayout());
		goalPart.add(new JLabel("GOAL : "));
		goalTextFieldX = new JTextField();
		goalTextFieldX.setPreferredSize(new Dimension(40,20));;
		goalTextFieldY = new JTextField();
		goalTextFieldY.setPreferredSize(new Dimension(40,20));;
		goalPart.add(goalTextFieldX);
		goalPart.add(goalTextFieldY);
		goalButton.addActionListener(new ActionAddGoal());
		goalPart.add(goalButton);
		settingPart.add(goalPart);
	}

	public GUImap getGmap() {
		return gmap;
	}

	public void setGmap(GUImap gmap) {
		this.gmap = gmap;
	}
	
	public Boolean getStartStop() {
		return startStop;
	}

	public void setStartStop(Boolean startStop) {
		this.startStop = startStop;
	}

	class ActionStartStop implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(startStop){
				startStop = false;
				startStopButton.setText("START");
			}
			else{
				startStop = true;
				startStopButton.setText("STOP");
			}
		}
	}
	
	class ActionAddGoal implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int x = Integer.parseInt(goalTextFieldX.getText());
			int y = Integer.parseInt(goalTextFieldY.getText());
			gmap.getMap().addGoal(x, y);
			gmap.refreshMap();
		}
	}
	
	class ActionAddStart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int x = Integer.parseInt(startTextFieldX.getText());
			int y = Integer.parseInt(startTextFieldY.getText());
			gmap.getMap().addStart(x, y);
			gmap.refreshMap();
		}
	}
}
