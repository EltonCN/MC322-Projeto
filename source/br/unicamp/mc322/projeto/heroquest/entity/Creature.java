package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.item.Armor;
import br.unicamp.mc322.projeto.heroquest.item.Item;
import br.unicamp.mc322.projeto.heroquest.item.Weapon;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.NullMovement;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.gamerunner.RunnableTurn;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;

public abstract class Creature extends HeroQuestEntity implements RunnableTurn, Attackable, Attacker, Movable {
    /** Attributes */
    /**
     * Número total de mãos que a criatura possui
     */
    private int totalHand;
    /**
     * Quantidade de dados de ataque que a criatura possui
     */
    private int nAttackDice;
    /**
     * Quantidade de dados de defesa que a entidade possui
     */
    private int nDefenseDice;
    /**
     * A vida da criatura
     */
    protected int life;
    /**
     * Itens que possui equipados
     */
    protected Weapon[] equippedWeapons;
    /**
     * Armadura que a criatura está vestindo
     */
    protected Armor armor;
    /**
     * Moedas de ouro que a criatura possui
     */
    protected int goldCoin;
    /**
     * Pontos de inteligência da criatura
     */
    protected int PI;
    /**
     * Número de mãos sendo usadas
     */
    protected int usedHand;
    /**
     * Ação de movimentação básica
     */
    protected Movement basicMovement;
    /**
     * Ação de ataque básica
     */
    protected Attack basicAttack;
    private static Attack PUNCH = new SimpleAttack(0, 1);
    /**
     * Amigável (bonzinho) ou não (malvado)
     */
    protected boolean isFriendly;

    protected boolean turn;

    /**
     * Caster (faz magia) ou não
     */
    protected boolean caster;
    /**
     * Operation Creature
     *
     * @param pose -
     * @param nAttackDice - Quantidade de dados de ataque que a criatura possui
     * @param nDefenseDice - Quantidade de dados de defesa que a criatura possui
     * @return
     */
    public Creature(Pose pose, int nAttackDice, int nDefenseDice) {
    	super(pose);
    	this.life = 1;
    	this.nAttackDice = nAttackDice;
    	this.nDefenseDice = nDefenseDice;
    	totalHand = 2; // Não pretendemos implementar nenhuma criatura com número diferente, mas se quisermos no futuro é possível adaptar com facilidade
        usedHand = 0; // No início, nenhuma mão está sendo usada, assume-se
    	basicMovement = new NullMovement();
    	basicAttack = PUNCH; //Apenas um soco simples
        turn = false;
        equippedWeapons = new Weapon[2];

    }

    /**
     * Operation Creature
     *
     * @param pose -
     * @param life -
     * @param nAttackDice - Quantidade de dados de ataque que a criatura possui
     * @param nDefenseDice - Quantidade de dados de defesa que a criatura possui
     * @return
     */
    public Creature (Pose pose, int life, int nAttackDice, int nDefenseDice) {
    	this(pose, nAttackDice, nDefenseDice);
    	this.life = life;
    }
    /**
     * Operation getNDefenseDice
     *
     * @return int
     */
    protected int getNDefenseDice() {
    	return nDefenseDice;
    }

    /**
     * Operation run
     * @return
     *
     * @return
     */
    public abstract void run();


    /**
     * Operation attack
     *
     * @return
     * @throws ActionFailedException
     */
    protected void attack() throws ActionFailedException {
    	if (equippedWeapons[0] != null)
    		basicAttack = equippedWeapons[0];
    	basicAttack.run(this);
    }

    /**
     * Operation move
     * Movimenta a entidade
     *
     * @param deltaX
     * @param deltaY
     * @return
     * @return boolean
     * @throws InvalidMovementException
     */
    protected void move(float deltaX, float deltaY) throws InvalidMovementException, DisabledEntityException
    {
    	super.moveBy(deltaX, deltaY, 0);
    }


    /**
     * Operation getDefenseScore
     * Retorna o numero de dados rolados com face de defesa pra cima
    */
    public abstract int getDefenseScore();

    //GETTER
    public boolean getIsFriendly() {
    	return isFriendly;
    }
    /**

     * Operation drop
     *
     * @return
     * @throws InvalidMovementException
     *//*
    protected drop ();*/ //TODO ADD DROP LATER

    public void moveBy(float deltaX, float deltaY) throws InvalidMovementException, DisabledEntityException
    {
        super.moveBy(deltaX, deltaY, 0);
    }

    /**
     * Operation equipItem
     * Permite que Criatura equipe um item segundo as regras do jogo:
     * Dois itens de uma mão ou um item de uma duas mãos
     */
    protected void equipWeapon(Weapon weapon) {
    	if (usedHand + weapon.getHands() < totalHand + 1) {
    		equippedWeapons[usedHand++] = weapon;
    		basicAttack = new SimpleAttack(0, 1);
    	}
    	else
    		addItemToInventory(weapon);
    }

    /**
     * Operation removeWeapon
     * @param weapon
     * @return Weapon
     */
    protected Weapon removeWeapon(int i) throws NullPointerException {
    	if (equippedWeapons[i] != null) {
    		Weapon toRemove = equippedWeapons[i];
    		equippedWeapons[i] = null;
    		usedHand -= toRemove.getHands();
    		if (i == 0) {
    			equippedWeapons[0] = equippedWeapons[1];
    			equippedWeapons[1] = null;
    		}
    		moveWeaponFromInventory();
    		if (i == 0) {
    			basicAttack = PUNCH;
    		}
    		return toRemove;
    	} else {
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Creature", "Não foi possível descartar a arma, pois ela não foi encontrada.");
			} catch (NotAvaibleServiceException | DisabledServiceException e) {
				e.printStackTrace();
			}

    	}
    	return null;
    }

    public void removeWeapon(Weapon w) {
    	try {
	    	if (equippedWeapons[0] == w)
	    		removeWeapon(0);
	    	else if (equippedWeapons[1] == w)
	    		removeWeapon(1);
	    	else {
	    		try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.OTHER, LogPriority.ERROR, "Creature's Weapon", "Uma tentativa de remover arma falhou: a arma não está em sua mão");
				} catch (NotAvaibleServiceException e1) {
					e1.printStackTrace();
				} catch (DisabledServiceException e1) {
					e1.printStackTrace();
				}
	    	}
    	} catch (NullPointerException e) {
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Creature's Weapon", "Uma tentativa de remover arma falhou:" + e.toString());
			} catch (NotAvaibleServiceException e1) {
				e1.printStackTrace();
			} catch (DisabledServiceException e1) {
				e1.printStackTrace();
			}

    	}
    }

    private void moveWeaponFromInventory() {
    	if (equippedWeapons.length != 0)
    		return;
    	for(Item i: inventory) {
    		try {
    			equipWeapon((Weapon) i);
    			return;
    		} catch(ClassCastException e) {
    			// Não faça nada!
    		}
    	}
    }

    public void takeDamage(float damage) 
    {
        if (this.armor == null) 
        {
            this.life -= damage;
        } 
        else 
        {
            this.life -= armor.transformDamage(damage);
        }

        if (life < 0) 
        {
            life = 0;
            this.disable();
        }
    }

    public int getAttackScore() {
        int score = 0;

        for(int i = 0; i < nAttackDice; i++) {
			if (CombatDice.getResult() == CombatDiceFace.SKULL){
				score += 1;
			}
        }
        return score;
    }

	public int getInteligence() {
		return PI;
	}

    public boolean isInTurn()
    {
        return turn;
    }

    public void startTurn()
    {
        turn = true;
    }
}
