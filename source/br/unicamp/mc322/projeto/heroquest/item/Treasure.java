package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.Lootable;
import br.unicamp.mc322.projeto.heroquest.action.Looter;
import br.unicamp.mc322.projeto.heroquest.entity.HeroQuestEntity;
import br.unicamp.mc322.projeto.heroquest.entity.Player;

public class Treasure extends HeroQuestEntity implements Lootable {
	
	public Treasure(Pose pose) {
		super(pose);
		setDefaultTreasure();
	}

	@Override
	public void toBeLooted(Looter looter) {
		for(int i = 0; i < inventory.size(); i++) {
			((Player) looter).enrich(inventory.get(i));
		}	
	}
	
	private void setDefaultTreasure() {
		for(int i = 0; i < inventory.size(); i++) {
			inventory.add(new GoldenCoin());
		}
	}
	
	

}
