package br.unicamp.mc322.projeto.gameengine.service;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

public class KeyboardInputService implements KeyInputService {

	JPanel watcher;
	boolean ignoringInput;
	KeyEvent lastEvent;
	
	public KeyboardInputService() throws NotAvaibleServiceException {
		watcher = (JPanel) ServiceManager.getInstance().getService(ServiceType.IMAGEOUTPUT);
		
		watcher.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recordEvent(evt);
            }

			@Override
			public void keyTyped(KeyEvent e) { // DO NOTHING
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) { // DO NOTHING
				// TODO Auto-generated method stub
			}
        });
		
		
		ignoringInput = true;
	}
	
	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public char getUserInput() {
		ignoringInput = false;
		
		// TODO FIX PROBLEMS
		try {
			new Thread().wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char input = lastEvent.toString().charAt(0);
		ignoringInput = true;
		lastEvent = null;
		return input;
	}
	
	private void recordEvent(KeyEvent evt) {
		lastEvent = evt;
	}

}
