package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import java.util.Scanner;

import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

public class ScannerInputService implements KeyInputService {
	
	Scanner input;
	
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
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getUserInput() {
		
		return Character.toLowerCase(input.next().strip().replace(" ", "").charAt(0));
	}

}

