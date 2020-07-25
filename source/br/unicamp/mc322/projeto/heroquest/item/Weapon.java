package br.unicamp.mc322.projeto.heroquest.item;

import java.lang.reflect.InvocationTargetException;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
import br.unicamp.mc322.projeto.heroquest.action.Attack;

public abstract class Weapon extends Item implements Attack
{
    /** Attributes */
    /**
     * Mãos que a arma consome
     */
    private int hand;
    /**
     * Usos que a arma possui
     */
    private int uses;
    /**
     * Lista de armas presentes no jogo
     */
    private static final Weapon[] WEAPONS_IN_GAME = {new LongSword(), new ShortSword(), new Dagger()};

    /**
     * Operation Weapon
     * Construtor de Weapon
     *
     * @param hand - Mãos que a arma usa
     * @param uses - Usos que a arma possui
     * @return 
     */    
    public Weapon (String name, float value, int hand, int uses) {
        super(name, value);
        this.hand = hand;
        this.uses = uses;
    }
    
    /*
     * Operation getWeapon
     * Retorna uma arma de certa classe a partir de um inteiro
     * 
     * @param int index
     * @return Weapon
     */
    private static Weapon getWeapon(int i) {
    	return (Weapon) WEAPONS_IN_GAME[i];
		
    }
    
    public static Weapon getRandomWeapon() {
    	try {
    		return getWeapon(new RandomGenerator(WEAPONS_IN_GAME.length).getResult() - 1);
    	} catch (IndexOutOfBoundsException e) {
    		
    		LogService l;
			try {
				l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Weapon", "Atempt to getRandomWeapon failed, long sword returned instead.");
			} catch (DisabledServiceException e1) {
				e1.printStackTrace();
			} catch (NotAvaibleServiceException e2) {
				e2.printStackTrace();
			}
    	}
    	return getWeapon(0);
    }

}

