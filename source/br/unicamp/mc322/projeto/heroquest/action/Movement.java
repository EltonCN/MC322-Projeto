package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public interface Movement extends Action 
{
	public static final float xStepSize = 48;
    public static final float yStepSize = 48;	
	/*
	 * Operation Movement
	 * It represents a pattern of movement
	 * 
	 * @param Creature - mover
	 * @return void
	 */
	public void move(Movable movable) throws ActionFailedException;
	
	public default void run(Entity origin) throws ActionFailedException 
	{
		try
		{
			Movable m = (Movable) origin;
			
			move(m);
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas movíveis podem se mover", e);
		}
	}
}

