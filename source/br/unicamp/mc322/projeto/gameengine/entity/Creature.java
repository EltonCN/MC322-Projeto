package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.item.Item;
import br.unicamp.mc322.projeto.gameengine.action.Attack;
import br.unicamp.mc322.projeto.gameengine.action.Movement;
import br.unicamp.mc322.projeto.gameengine.entity.CharacterCommander;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public abstract class Creature extends Entity
{
    /** Attributes */
    /**
     * 
     */
    protected int vida;
    /**
     * 
     */
    protected boolean caster;
    /**
     * 
     */
    protected Item itensEquipados;
    /**
     * 
     */
    protected Armadura armadura;
    /**
     * 
     */
    protected int dinheiro;
    /**
     * 
     */
    protected Attack basicAttack;
    /**
     * 
     */
    protected Movement basicMovement;
    /**
     * 
     */
    protected int PI;
    /**
     * 
     */
    protected CharacterCommander commander;
    /** Associations */
    private CharacterCommander unnamed_15;
    private Movement unnamed_12;
    private Attack unnamed_11;
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

