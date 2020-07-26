package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowOutputService extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 474318554059464017L;
	private static final int horizontalDimension = 900;
	private static final int verticalDimension = 700;
	
	
	private JLabel background;
	
	//get and load Background Image [TEMPORARY]
	public WindowOutputService() {
		setUI();
		
		background = new JLabel(new ImageIcon("SpriteSheet"));
		
		add(background, BorderLayout.NORTH);
		
		background.setLayout(/*new GridLayout(3,3)*/new FlowLayout());
		
		forceRefresh();
	}

	
	//Set screen sizes
	private void setUI() {
		setTitle("Heroe Quest");
		
		add(new SpriteImageOutputService());
       
        setSize(horizontalDimension, verticalDimension);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     
        setLayout(new BorderLayout()); //Esse é o layout do JFrame DA CLASSE 
	}
	
	private void forceRefresh() {
		setSize(horizontalDimension -1, verticalDimension -1);
        setSize(horizontalDimension, verticalDimension);	
	}
	

	
	
}
