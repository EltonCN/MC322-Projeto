package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public class WindowOutputService extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 474318554059464017L;
	private static final int horizontalDimension = 900;
	private static final int verticalDimension = 700;
	
	
	private JLabel /*room*/background;
//	private JLabel hallwaybackground;
//	private JLabel downMenu;
	private JPanel foreground;
	
	//� NECESSARIO FAZER ADD(FOREGROUND) ANTES DE ADD(BACKGROUND)
		
	
	public WindowOutputService() {
		setUI();
		
		//O que � necess�rio: 
		//	se � um corredor ou sala
		
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
     
        setLayout(new BorderLayout()); //Esse � o layout do JFrame DA CLASSE 
	}
	
	public void setForeground(SpriteExtrinsic sprite) {
		//Esse � o painel de impress�o da sala ou corredor
		
		//O que � necess�rio: 
		//	Quais entidades est�o nele
		//	Quais obstaculos est�o nele
		
		//Ideia:
		//SpriteImageOutput deve ter acesso 
	
	}
	
	
	
	private void forceRefresh() {
		setSize(horizontalDimension -1, verticalDimension -1);
        setSize(horizontalDimension, verticalDimension);	
	}
	

	
	
}
