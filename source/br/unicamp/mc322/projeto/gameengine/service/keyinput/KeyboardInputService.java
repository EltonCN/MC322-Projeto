package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;

/**
 * Leitura de input a partir do teclado com KeyEvent
 * @author lucas
 *
 */

public class KeyboardInputService implements KeyInputService {

	private JPanel watcher;
	private KeyEvent lastEvent;
	@SuppressWarnings("unused")
	private boolean ended;

	public KeyboardInputService() throws NotAvaibleServiceException {
		watcher = (JPanel) ServiceManager.getInstance().getService(ServiceType.IMAGEOUTPUT);

		watcher.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recordEvent(evt);
            }

			@Override
			public void keyTyped(KeyEvent e) { // faça nada
				///@todo Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) { // faça nada
				///@todo Auto-generated method stub
			}
        });

		ended = false;
		lastEvent = null;
	}

	@Override
	public void end() {
		ended = true;

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
