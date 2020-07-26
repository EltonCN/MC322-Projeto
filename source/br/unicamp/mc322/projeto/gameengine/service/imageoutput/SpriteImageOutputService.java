package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public class SpriteImageOutputService extends JPanel implements ImageOutputService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9215279814288548818L;
	private static final int horizontalEdge = 66;
	private static final int verticalEdge = 0;

	
	public SpriteImageOutputService() {
		super();
		setGUI();
		
		repaint();
	}
	
	
	private void setGUI() {
		
		
		
	}
	


	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws DisabledServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSprite(SpriteExtrinsic sprite) throws DisabledServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getXSize() throws DisabledServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYSize() throws DisabledServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
