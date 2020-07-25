package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;

public interface Attack extends Action
{
    public static Metric metric = Metric.EUCLIDEAN;

    /**
     * Executa o ataque com um objetivo específico
     */
    public default void run (Entity origin, Entity target) throws ActionFailedException
    {
        Attacker a;
        Attackable t;

        try
		{
			a = (Attacker) origin;
			
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas atacantes podem atacar", e);
        }
        
        try
		{
			t = (Attackable) target;
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas atacáveis podem ser atacados", e);
        }
        
        attack(a, t);
    }

    public default void run(Entity origin) throws ActionFailedException
    {
        Attacker a;

        try
		{
			a = (Attacker) origin;
			
		}
		catch(ClassCastException e)
		{
			throw new ActionFailedException("Apenas atacantes podem atacar", e);
        }

        attack(a);
    }

    public void attack(Attacker origin, Attackable target) throws ActionFailedException;

    public void attack(Attacker origin) throws ActionFailedException;
    
}

