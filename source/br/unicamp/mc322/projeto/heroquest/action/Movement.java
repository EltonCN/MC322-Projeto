package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

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
	
	public default void run (Entity origin) throws ActionFailedException {
		run((Creture) origin);
	}
	
	public default void run(Creature origin) throws ActionFailedException
	{
		try
		{
			move((Movable) origin);
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas movíveis podem se mover", e);
		}
		
	}

}

