package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Interactable;

public interface Lootable extends Interactable {
	
	public default void interact(Entity activator) {
		toBeLooted((Looter) activator);
	}
	
	public void toBeLooted(Looter looter);

}
