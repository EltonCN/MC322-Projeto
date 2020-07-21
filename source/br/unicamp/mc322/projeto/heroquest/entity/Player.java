package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;
import br.unicamp.mc322.projeto.heroquest.entity.Curable;

public abstract class Player extends Creature implements Curable
{
	/** Attributes */
    /**
     * Nome do jogador
     */
    private String name;
    
	
    public Player(Pose pose, int nAttackDice, int nDefenseDice) {
		super(pose, nAttackDice, nDefenseDice);
	}
	
    @Override
    public boolean isPermanent() {
    	return true;
    }
}

