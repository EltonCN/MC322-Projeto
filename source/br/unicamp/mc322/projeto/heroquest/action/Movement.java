package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

public interface Movement extends Action 
{
	public static final float xStepSize = 1;
    public static final float yStepSize = 1;	
	/*
	 * Operation Movement
	 * It represents a pattern of movement
	 * 
	 * @param Creature - mover
	 * @return void
	 */
	public abstract void move(Creature mover);
	
	@Override
	public default void run(Entity origin) {
		move((Creature) origin);
	}

}

