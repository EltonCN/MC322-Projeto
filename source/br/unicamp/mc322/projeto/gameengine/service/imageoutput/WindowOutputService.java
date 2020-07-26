package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;


public class WindowOutputService extends JFrame implements ImageOutputService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 474318554059464017L;
	private static final int horizontalDimension = 900;
	private static final int verticalDimension = 700;
	
	
	private JLabel /*room*/background;
//	private JLabel hallwaybackground;
//	private JLabel downMenu;
	private SpriteImageOutputService foreground;
	
	//É NECESSARIO FAZER ADD(FOREGROUND) ANTES DE ADD(BACKGROUND)
		
	
	public WindowOutputService() {
		setUI();
		
		//O que é necessário: 
		//	se é um corredor ou sala
		
		background = new JLabel(new ImageIcon("PATH_TO_BACKGROUND_IMAGE"));
		
		add(background, BorderLayout.NORTH);
		
		background.setLayout(new FlowLayout());
		
		forceRefresh();
	}

	//Set screen and foreground
	private void setUI() {
		setTitle("Heroe Quest");
		
		setForeground();
		add(foreground);
       
        setSize(horizontalDimension, verticalDimension);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     
        setLayout(new BorderLayout()); //Esse é o layout do JFrame DA CLASSE 
	}
	
	private void setForeground() {
		
		foreground = new SpriteImageOutputService();
		
	}
	
	private void forceRefresh() {
		setSize(horizontalDimension -1, verticalDimension -1);
        setSize(horizontalDimension, verticalDimension);	
	}
	
	
	@Override //throws DisabledServiceException
	public void addSprite(SpriteExtrinsic sprite, int x, int y, int angle) {
		
		foreground.add(sprite, x, y, angle);
		
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public int getXSize() {
		return 0;
	}
	
	public int getYSize() {
		return 0;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	
}
