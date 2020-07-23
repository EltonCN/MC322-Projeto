package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.item.Armor;
import br.unicamp.mc322.projeto.heroquest.item.Item;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.HeroQuestEntity;
import br.unicamp.mc322.projeto.gameengine.service.RunnableTurn;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;

public abstract class Creature extends HeroQuestEntity implements RunnableTurn, Attackable
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
     * Identifica a criatura como lançadora de magia
     */
    protected boolean caster;
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
     *
     * @return 
     */
    public run () {
    	
    }

    /**
     * Operation sofrerAtaque
     *
     * @param damage
     * @return 
     */
    public void takeDamage(int damage) {
    	if (damage >= 0)
    		life -= damage;
    	else; //TODO ADD EXCEPTION A1 MAYBE?
    }

    /**
     * Operation realizarAtaque
     *
     * @return 
     */
    protected realizarAtaque (  );

    /**
     * Operation move
     * Movimenta a entidade
     *
     * @param deltaX
     * @param deltaY
     * @return 
     * @return 
     */
    protected void move (float deltaX, float deltaY) {
    	moveBy(deltaX, deltaY, 0);
    }

    /**
     * Operation moveN
     * Movimenta a entidade para o norte
     * @return
     */
    public void moveN() {
    	move(0, 1);
    }
    /**
     * Operation moveS
     * Movimenta a entidade para o norte
     * @return
     */
    public void moveS() {
    	move(0, -1);
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return
     */
    public void moveE() {
    	move(1, 0);
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return
     */
    public void moveW() {
    	move(-1, 0);
    }
    /**
     * Operation getDefenseScore
     * Retorna o numero de dados rolados com face de defesa pra cima
    */
    public abstract int getDefenseScore();

    /**
     * Operation drop
     *
     * @return 
     *//*
    protected drop ();*/ //TODO ADD DROP LATER

}

