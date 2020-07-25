package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.item.Armor;
import br.unicamp.mc322.projeto.heroquest.item.Item;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.heroquest.action.Movable;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.RunnableTurn;

public abstract class Creature extends HeroQuestEntity implements RunnableTurn, Attackable, Attacker, Movable
{
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
    protected Item[] equippedItem;
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
    protected int handUsed;
    /**
     * Ação de movimentação básica
     */
    protected Movement basicMovement;
    /**
     * Ação de ataque básica
     */
    protected Attack basicAttack;
    /**
     * Ação de ataque básica
     */
    protected boolean isFriendly;
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
    	totalHand = 2;
    	basicMovement = new NullMovement();
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
     * Operation sofrerAtaque
     *
     * @param damage
     * @return void
     */
    public void takeDamage(int damage) {
    	if (damage >= 0)
    		life -= damage;
    	else; //TODO ADD EXCEPTION A1 MAYBE?
    }

    /**
     * Operation attack
     * 
     * @return 
     * @throws ActionFailedException 
     */
    protected void attack() throws ActionFailedException {
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
    protected void move(float deltaX, float deltaY) throws InvalidMovementException {
    	moveBy(deltaX, deltaY, 0);
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

    public void moveBy(float deltaX, float deltaY) throws InvalidMovementException {
        moveBy(deltaX, deltaY, 0);
    }

    public void takeDamage(float damage) {
        if (this.armor == null) {
            this.life -= damage;
        } else {
            this.life -= armor.transformDamage(damage);
        }

        if (life < 0) {
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

}

