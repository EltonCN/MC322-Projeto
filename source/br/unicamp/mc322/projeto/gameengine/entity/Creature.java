package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.item.Armor;
import br.unicamp.mc322.projeto.gameengine.item.Item;
import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.action.Attack;
import br.unicamp.mc322.projeto.gameengine.action.Movement;
import br.unicamp.mc322.projeto.gameengine.entity.CharacterCommander;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public abstract class Creature extends Entity
{
    public Creature(String name, Pose pose) {
		super(name, pose);
		// TODO Auto-generated constructor stub
	}

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
    protected Armor armor;
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

