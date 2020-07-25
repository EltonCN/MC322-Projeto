package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Curable;

public interface Cure extends Action {
	
	@Override
	public default void run(Entity origin) throws ActionFailedException
	{
		try
		{
			Curable c = (Curable) origin;
			
			cure(c);
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas curáveis podem ser curados", e);
		}
		
	}
	
	public void cure(Curable origin) throws ActionFailedException;
    
}


