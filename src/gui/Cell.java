package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import map.Coordinate;

public class Cell extends JPanel{
	
	public static final int CELL_SIZE = 1;
    private Coordinate coord;

    public Cell (int x, int y) {
        coord = new Coordinate(x, y);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(223,242,255));
        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
    }

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
}
