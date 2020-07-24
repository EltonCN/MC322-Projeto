package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Curable;

public interface Cure extends Action {
	@Override
	public default void run(Entity origin) {
		cure((Curable) origin);
	}
	
	public default void cure(Curable xaman) {
		xaman.cureLife(1);
	}
}

