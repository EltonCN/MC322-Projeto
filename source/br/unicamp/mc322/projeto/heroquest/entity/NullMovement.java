package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Movable;
import br.unicamp.mc322.projeto.heroquest.action.Movement;

public class NullMovement implements Movement {

	@Override
	public void run(Entity origin) {

	}

	@Override
	public void move(Movable movable) throws ActionFailedException
	{
	}

}
