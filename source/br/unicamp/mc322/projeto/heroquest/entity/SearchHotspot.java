package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;

public class SearchHotspot extends HeroQuestEntity implements Interactable {
	
	public SearchHotspot(Pose pose) {
		super(pose);
		//bad = ; @todo implementar pegar inimigo em algum lugar
	}

	@Override
	public void interact(Entity activator) {
		int odds = D6Dice.getResult();
		if (odds < 5)
			invokeTreasure();
		else
			invokeMonster();
	}
	
	private void invokeMonster() {
		
	}
	
	private void invokeTreasure() {
		
	}

}
