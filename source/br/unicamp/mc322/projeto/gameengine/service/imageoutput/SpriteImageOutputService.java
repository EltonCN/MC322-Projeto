package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.resource.ImageResourceService;

import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceType;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;


public class SpriteImageOutputService extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9215279814288548818L;
	private static final int gridSquareSize = 48;
	//Sizes given in pixels in order to handle 48 pixels squared of grid/sprite dimension
	private static final int horizontalSize = 16*gridSquareSize;
	private static final int verticalSize = 9*gridSquareSize;
	//The map will have proportion of 16:9

	private static final int horizontalEdge = (WindowOutputService.horizontalDimension -horizontalSize)/2;
	private static final int verticalEdge = (WindowOutputService.verticalDimension -verticalSize)/2;;

	private Graphics g;

	
		
	public SpriteImageOutputService() {
		super();
			
		setGUI();
		
		
		// TODO testar com repaint()
		//Verificar como deletar g e criar outra do 0
//		paintComponent(g);
		repaint();
	}
	
	private void setGUI() {
		g = this.getGraphics();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		requestEntities(g);
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	

	private void doDrawing(Graphics g, Entity toDraw) throws DisabledEntityException {
		
		Graphics2D g2d = (Graphics2D) g;
		
		setGrid(g2d);
		
		try {

			ServiceManager m = ServiceManager.getInstance();
	        
			ImageResourceService s = (ImageResourceService) m.getService(ServiceType.RESOURCE);
	        
			SpriteExtrinsic se = (SpriteExtrinsic) s.getResource(ResourceType.IMAGE, toDraw.getClass(), 0);
	        //AINDA � PRECISO DECIDIR SOBRE O USO DO INDEX, TALVEZ TENHA QUE HAVER 2 DELES
			
			
			Image i;
			if (se == null) 
				{i = null;}
			else 
				{i = new ImageIcon(se.getSprite().getPath()).getImage();}
			
			
			
			//This operation is made so the reference point shifts to
			//the upper left corner of the grid and the map. Before that
			//the reference was the lower left both map and grid.
			int coordY = verticalEdge +verticalSize -((int) se.getPose().getY() +48);
			int coordX = horizontalEdge +(int) se.getPose().getX();
			
			g2d.drawImage(i, coordX, coordY, this);
		
			
		}catch(ServiceException e) {
			
		}
		
		
	} 
	
	private void doDrawing(Graphics g, SpriteExtrinsic se) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		setGrid(g2d);
		
		
		Image i;
		if (se == null) 
			{i = null;}
		else 
			{i = new ImageIcon(se.getSprite().getPath()).getImage();}
					
			
		//This operation is made so the reference point shifts to
		//the upper left corner of the grid and the map. Before that
		//the reference was the lower left both map and grid.
		int coordY = verticalEdge +verticalSize -((int) se.getPose().getY() +48);
		int coordX = horizontalEdge +(int) se.getPose().getX();
			
		g2d.drawImage(i, coordX, coordY, this);
			
	}
	
	//FUN��O QUE PEGA A LISTA DE ENTIDADES NA SALA
	private void requestEntities(Graphics g) {
				
		try {
            ServiceManager m = ServiceManager.getInstance();
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            for (int i=0; i < s.countEntity(); i++) {
            	
            	try {doDrawing(g, s.getEntity(i));} 
            	catch(DisabledEntityException e) {continue;}	
            	
            }
      
		} catch(ServiceException e) {
        	
        }
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
	//uncharted territory
	void refreshMap() {
		Graphics g_aux = g.create();
		
		g.dispose();
		
		this.g = g_aux;
		
		// TODO testar com repaint()
		//Verificar como deletar g e criar outra do 0
//		paintComponent(g);
		repaint();
	}
	
	void add(SpriteExtrinsic sprite) {
		
		doDrawing(g, sprite);
		
		refreshMap();
		repaint();
	}
	
}
