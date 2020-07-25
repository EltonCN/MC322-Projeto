package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

public interface Cure extends Action {
	
	@Override
	public default void run(Entity origin) {
		run((Creature) origin);
	}
	
	public void run(Creature origin);
    
}


