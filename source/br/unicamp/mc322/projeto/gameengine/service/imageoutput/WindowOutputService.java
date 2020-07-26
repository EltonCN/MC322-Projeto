package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;


public class WindowOutputService extends JFrame implements ImageOutputService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 474318554059464017L;
	private static final int horizontalDimension = 900;
	private static final int verticalDimension = 700;
	
	
	private JLabel background;
	private SpriteImageOutputService foreground;
			
	
	public WindowOutputService() {

		setForeground();
		setBackground();
		setUI();
		
			
		
		
		
		
		forceRefresh();
	}

	//Set screen and foreground
	private void setUI() {
		setTitle("Heroe Quest");
		
		add(foreground);
		add(background, BorderLayout.NORTH);
		
        setSize(horizontalDimension, verticalDimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout()); 
	}
	
	private void setForeground() {
		
		foreground = new SpriteImageOutputService();
		
	}
	private void setBackground() {
		//NECESSARIO SABER SE É SALA OU CORREDOR
		background = new JLabel(new ImageIcon("PATH_TO_BACKGROUND_IMAGE"));
		background.setLayout(new FlowLayout());
		
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
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	
}
