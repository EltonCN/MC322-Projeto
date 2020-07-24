package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public interface Reaction extends Action {
	@Override
	public default void run(Entity origin) {
		react();
	}
	
	public void react();
}

