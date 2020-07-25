package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

public class KeyboardInputService implements KeyInputService {

	JPanel watcher;
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
		
		
		lastEvent = null;
	}
	
	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public char getUserInput() {
		
		lastEvent = null;
		
		// TODO MELHORAR IMPLEMENTAÇÃO
		while(lastEvent == null) {
			try {
				Thread.currentThread().wait(100);
			} catch (InterruptedException e) {
				// DO NOTHING
			}
		}
		
		char input = lastEvent.toString().charAt(0);
		lastEvent = null;
		return input;
	}
	
	private void recordEvent(KeyEvent evt) {
		lastEvent = evt;
	}

}
