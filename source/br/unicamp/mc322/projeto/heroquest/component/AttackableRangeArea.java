package br.unicamp.mc322.projeto.heroquest.component;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

public class AttackableRangeArea extends EntityRangeArea {
	
	// In a few cases, it is intersting to have info about the entire stage's attackables
	public AttackableRangeArea() {
		super(new Pose(0, 0, 0), 15, Metric.MANHATTAN); //TODO CHANGE 15 TO A STAGE SOMETHING CONSTANT
	}
	
	private void remove(Attackable[] at, int i) {
		for (int j = i; j < at.length - 1; j++) {
			at[j] = at[j + 1];
		}
	}
	
	public Attackable[] getAttackablesInsideToAttacker(Creature attacker) {
		Attackable[] foes = getAttackablesInside();
		for(int i = 0; i < foes.length; i++) {
			if (attacker.getIsFriendly() == ((Creature) foes[i]).getIsFriendly())
				remove(foes, i--); // Preventing enemies/players attack themselves && the minus guarantees all Attackables are checked
		}
		
		return foes;
	}
	
	public Attackable[] getAttackablesInside() {
		
		Entity[] entities = getEntitiesInside();
		Attackable[] attackables = new Attackable[225]; //TODO CHANGE 225 TO A STAGE CONSTANT
		int added = 0;
		
		for(int i = 0; i < entities.length; i++) {
			try {
				attackables[added++] = (Attackable) entities[i];
			} catch (ClassCastException e) {
				added--;
			}
		}
		return attackables;
	}

}
