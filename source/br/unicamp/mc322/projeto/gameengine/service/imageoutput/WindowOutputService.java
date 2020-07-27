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
	static final int horizontalDimension = 900;
	static final int verticalDimension = 700;
	private boolean ended;
	
	private JLabel background;
	private SpriteImageOutputService foreground;
			
	
	public WindowOutputService() {
		ended = false;
		
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
	
	private boolean hasEnded() {
		return this.ended;
	}
		
	@Override
	public void addSprite(SpriteExtrinsic sprite) {		
		if (hasEnded()) {}
		else {
			foreground.add(sprite);
		}	
	}
	
	@Override
	public void update() {
		if (hasEnded()) {}
		else {
			foreground.refreshMap();		
		}
	}
	
	@Override
	public void end() {
		this.ended = true;
		
	}
	
	
}
