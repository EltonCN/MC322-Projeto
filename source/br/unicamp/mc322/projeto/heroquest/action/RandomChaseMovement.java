package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public class RandomChaseMovement extends ChaseMovement {

	Movement alternative;
	
	public RandomChaseMovement() {
		super();
		alternative = new RandomMovement();
	}
	
	@Override
	public void move(Movable mover) throws ActionFailedException {
		Attackable foe = chooseFoe((Creature) mover, getFoes((Creature) mover));
		
		try {
			if(foe.getPose().distance(((Entity) mover).getPose(), Metric.MANHATTAN) > 2)
				alternative.move(mover);
			else
				super.move(mover);
		} catch (ClassCastException e) {
			alternative.move(mover);
		}
		
	}

}
