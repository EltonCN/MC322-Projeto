package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import java.util.Scanner;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;

/**
 * Leitura de input a partir do teclado com Scanner
 * @author lucas
 *
 */
public class ScannerInputService implements KeyInputService {
	
	private Scanner input;
	@SuppressWarnings("unused")
	private boolean ended;
	
	public ScannerInputService() {
		this.input = new Scanner(System.in);
		try {
			LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
			l.sendLog(LogType.KEYINPUT, LogPriority.WARNING, "Scanner", "Resource might be limited");
		} catch (NotAvaibleServiceException e) {
			e.printStackTrace();
		} catch (DisabledServiceException e) {
			e.printStackTrace();
		}
		
		ended = false;
	}

	@Override
	public void end() {
		ended = true;
		
	}

	@Override
	public char getUserInput() {
		
		return Character.toLowerCase(input.next().strip().replace(" ", "").charAt(0));
	}

}

