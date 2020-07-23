package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Movement;

public class NullMovement implements Movement {

	@Override
	public void run(Entity origin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Creature mover) {
		// STAY!
	}

}
