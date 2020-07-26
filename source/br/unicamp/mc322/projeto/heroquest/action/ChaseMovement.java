package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public class ChaseMovement implements Movement {
	
	private Attackable chooseFoe(Creature mover, Attackable[] foes) {
		float minDistance = Float.MAX_VALUE;
		Attackable theFoe = foes[0];
		float distance;
		for(Attackable foe: foes) {
			distance = mover.getPose().distance(((Entity) foe).getPose(), Metric.MANHATTAN);
			if (distance < minDistance) {
				theFoe = foe;
				minDistance = distance;
				
			}
		}
		return theFoe;
	}
	
	private Attackable[] getFoes(Creature mover) {
		return new AttackableRangeArea().getAttackablesInside(mover);
	}

	@Override
	public void move(Movable movable) throws ActionFailedException {
		Attackable foe = chooseFoe((Creature) movable, getFoes((Creature) movable));
		if (((Entity) movable).getPose().distance(((Entity) foe).getPose(), Metric.MANHATTAN) == 1)
			return; // Movable pode atacar foe: não é necessário se mover
		
		try
		{
			if (((Entity) movable).getPose().getX() < ((Entity) foe).getPose().getX())
			{
				try
				{
					movable.moveE();
					return;
				} catch (InvalidMovementException e) 
				{
					// Não faça nada: comportamento esperado
				}
			}
			
		
			if (((Entity) movable).getPose().getX() > ((Entity) foe).getPose().getX())
			{
				try 
				{
					movable.moveW();
					return;
				} 
				catch (InvalidMovementException e) 
				{
					// Não faça nada: comportamento esperado
				}

			}
				
		
			if (((Entity) movable).getPose().getY() < ((Entity) foe).getPose().getY())
			{
				try 
				{
					movable.moveN();
					return;
				} 
				catch (InvalidMovementException e) 
				{
					// Não faça nada: comportamento esperado
				}
			}
				
		
			if (((Entity) movable).getPose().getY() > ((Entity) foe).getPose().getY())
			{
				movable.moveS();
			}
				
			}
			catch(DisabledEntityException e)
			{
				throw new ActionFailedException("A entidade está desabilitada", e);
			}
			catch(InvalidMovementException e)
			{
				throw new ActionFailedException("Não foi possível se movimentar para nenhuma direção", e);
			}

		
		
	}
}

