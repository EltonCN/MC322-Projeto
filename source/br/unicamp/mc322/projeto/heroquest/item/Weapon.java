package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

public abstract class Weapon extends Item implements Attack {
    /** Attributes */
    /**
     * Mãos que a arma utiliza
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

    protected SimpleAttack attack;
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
    
    /**
     * Operation getHands
     * Retorna número de mãos necessárias para conduzir a arma
     * 
     * @return int
     */
    public int getHands() {
    	return hand;
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
    		return getWeapon(new RandomGenerator(WEAPONS_IN_GAME.length).getResult());
    	} catch (IndexOutOfBoundsException e) {
    		
    		LogService l;
			try {
				l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Weapon", "Atempt to getRandomWeapon failed, long sword returned instead: " + e);
			} catch (DisabledServiceException e1) {
				e1.printStackTrace();
			} catch (NotAvaibleServiceException e2) {
				e2.printStackTrace();
			}
    	}
    	return getWeapon(0);
    }
    
    @Override
    public void attack(Attacker origin, Attackable target) throws ActionFailedException {
        attack.attack(origin, target);
        if (--uses < 1)
        	try {
        		((Creature) origin).removeWeapon(this);
        	} catch(ClassCastException e) {
        		try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.OTHER, LogPriority.ERROR, "Attacker's Weapon", "Tentativa de conversão inválida de Attacker para Creature");
				} catch (NotAvaibleServiceException | DisabledServiceException e1) {
					e1.printStackTrace();
				}
        		
        	}
        	
    }

    @Override
    public void attack(Attacker origin) throws ActionFailedException {
        attack.attack(origin);
        if (--uses < 1)
        	try {
        		((Creature) origin).removeWeapon(this);
        	} catch(ClassCastException e) {
        		try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.OTHER, LogPriority.ERROR, "Attacker's Weapon", "Tentativa de conversão inválida de Attacker para Creature");
				} catch (NotAvaibleServiceException | DisabledServiceException e1) {
					e1.printStackTrace();
				}
        		
        	}
    }

}

