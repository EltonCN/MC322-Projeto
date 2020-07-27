package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceType;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SpritePriority;

public class SpriteImageOutputService extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9215279814288548818L;
	private static final int horizontalEdge = 66;
	private static final int verticalEdge = 0;
	private static final int gridSquareSize = 48;
	//Sizes given in pixels in order to handle 48 pixels squared of grid/sprite dimension
	private static final int horizontalSize = 16*gridSquareSize;
	private static final int verticalSize = 9*gridSquareSize;
	//The map will have proportion of 16:9
	
		
	public SpriteImageOutputService() {
		super();
		setGUI();
		
		repaint();
	}
	
	private void setGUI() {
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		setGrid(g2d);
		
		
	} 
	
	private void setGrid(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);

		int x = horizontalEdge; int y = verticalEdge;
		
		//DRAW LINES
		while (y < verticalSize + (2*gridSquareSize)) {
			g2d.drawLine(x, y, x +horizontalSize, y);
			y += gridSquareSize;
		}	
		y = 0;
		//DRAW COLUMNS
		while (x < horizontalSize + (2*gridSquareSize)) {
			g2d.drawLine(x, y, x, y +verticalSize);
			x += gridSquareSize; 
		}
		
	}
	
	void add(SpriteExtrinsic sprite, int x, int y, int angle) {
		
		
		
	}
	

}
