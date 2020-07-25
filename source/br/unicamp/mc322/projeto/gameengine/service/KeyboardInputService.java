package br.unicamp.mc322.projeto.gameengine.service;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
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
			public void keyTyped(KeyEvent e) { // faça nada
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) { // faça nada
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
		
		int cycles = 0;
		while(lastEvent == null) {
			try {
				Thread.currentThread().wait(100);
			} catch (InterruptedException e) {
				if(++cycles % 10 != 0) // Apenas a cada segundo relate o tempo de espera pelo usuário
					continue;
				try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.KEYINPUT, LogPriority.LOG, "KeyboardInputService", "Esperando a entrada do usuário a " + cycles/10  + " segundos.");
				} catch (NotAvaibleServiceException e1) {
					e1.printStackTrace();
				} catch (DisabledServiceException e1) {
					e1.printStackTrace();
				}
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
