package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

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
	public abstract void move(Movable movable);
	
	@Override
	public default void run(Entity origin) throws ActionFailedException
	{
		try
		{
			move( (Movable) origin);
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas movíveis podem se mover", e);
		}
		
	}

}

