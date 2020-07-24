package br.unicamp.mc322.projeto.heroquest.action;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

public class ChaseMovement implements Movement {

	@Override
	public void run(Entity origin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Creature mover) {
		Attackable foe = chooseFoe(mover, getFoes(mover)); // Every attackable is an entity, then exceptions are unlikely to occur
		if (mover.getPose().distance(((Entity) foe).getPose(), Metric.MANHATTAN) == 1)
			return; // Mover can already attack foe, no move needed 
		if (mover.getPose().getX() < ((Entity) foe).getPose().getX())
			mover.moveE();
		else if (mover.getPose().getX() > ((Entity) foe).getPose().getX())
			mover.moveW();
		else if (mover.getPose().getY() < ((Entity) foe).getPose().getY())
			mover.moveN();
		else if (mover.getPose().getY() > ((Entity) foe).getPose().getY())
			mover.moveS();
		

	}
	
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
		return new AttackableRangeArea().getAttackablesInsideToAttacker(mover);
	}
}

