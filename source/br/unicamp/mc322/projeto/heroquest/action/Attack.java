package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public interface Attack extends Action {
	@Override
	public default void run(Entity origin) {
		attack();
	}
	
	public void attack();
}

