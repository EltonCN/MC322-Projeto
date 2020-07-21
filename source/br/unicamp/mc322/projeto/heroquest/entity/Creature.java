package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.item.Armor;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.HeroQuestEntity;
import br.unicamp.mc322.projeto.gameengine.service.RunnableTurn;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;

public abstract class Creature extends HeroQuestEntity implements RunnableTurn implements Attackable
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
    public Creature ( Pose pose, int nAttackDice, int nDefenseDice );

    /**
     * Operation Creature
     *
     * @param pose - 
     * @param life - 
     * @param nAttackDice - Quantidade de dados de ataque que a criatura possui
     * @param nDefenseDice - Quantidade de dados de defesa que a criatura possui
     * @return 
     */
    public Creature ( Pose pose, int life, int nAttackDice, int nDefenseDice );

    /**
     * Operation run
     *
     * @return 
     */
    public run (  );

    /**
     * Operation sofrerAtaque
     *
     * @return 
     */
    protected sofrerAtaque (  );

    /**
     * Operation curar
     *
     * @return 
     */
    protected curar (  );

    /**
     * Operation realizarAtaque
     *
     * @return 
     */
    protected realizarAtaque (  );

    /**
     * Operation move
     * Movimenta a e
     *
     * @return 
     */
    protected move (  );

    /**
     * Operation drop
     *
     * @return 
     */
    protected drop (  );

}

