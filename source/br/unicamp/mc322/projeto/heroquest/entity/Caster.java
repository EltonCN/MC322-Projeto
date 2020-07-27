package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.KeyInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.magic.Magic;

public interface Caster 
{
    public int getInteligence();
    public Magic getMagic(int i);
    public int getNMagics();
    
    public default void runMagics() throws ActionFailedException {
    	
    	try {
    		if (!((Player) this).caster) return;
    			// Essa condição na verdade é para levantar um erro e sempre impedir que ele seja executado em inimigos
    			// Isso não acontece atualmente, mas poderia com a adição de novos monstros e funcionalidades
    	} catch (ClassCastException e) {
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.WARNING, "Player", "Tentativa de controlar a magia de um inimigo pelo jogador ("  + e + "): magic unsuccessful");
			} catch (NotAvaibleServiceException | DisabledServiceException e1) {
				e1.printStackTrace();
			}
			
    	}
    	
    	try {
    		KeyInputService k = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);
	    	int num = getNMagics();
	   		boolean magicDone = false;
	   		
	   		do {
	       		char magicChosen = k.getUserInput();
	       		if (magicChosen < num) {
	       			try {
						((Caster) this).getMagic(Character.getNumericValue(magicChosen)).run((Entity) this);
						magicDone = true;
					} 
	       			catch (ClassCastException e) {
	       				throw new ActionFailedException(e.toString() + ": apenas Casters podem usar magia");
	       			}
	       			catch (ActionFailedException e) {
						LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
						l.sendLog(LogType.OTHER, LogPriority.LOG, "Player", "Action failed ("  + e + "): magia malsucedida");
					}
	       		} 
	   		} while(!magicDone);
    } catch (Exception e) {
    	
    }
    }
}