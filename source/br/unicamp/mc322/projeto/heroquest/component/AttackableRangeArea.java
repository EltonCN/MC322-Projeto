package br.unicamp.mc322.projeto.heroquest.component;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;

/**
 * Representa uma área de alcance de ataque
 */
public class AttackableRangeArea extends EntityRangeArea {
	
	// In a few cases, it is intersting to have info about the entire stage's attackables
	public AttackableRangeArea() {
		super(new Pose(0, 0, 0), Integer.MAX_VALUE, Metric.MANHATTAN);
	}
	
	public AttackableRangeArea(Pose origin, float range, Metric metric)
	{
		super(origin, range, metric);
	}

	private void remove(Attackable[] at, int i) {
		for (int j = i; j < at.length - 1; j++) {
			at[j] = at[j + 1];
		}
	}
	
	public Attackable[] getAttackablesInside(Attacker attacker) {
		Attackable[] foes = getAttackablesInside();
		for(int i = 0; i < foes.length; i++) 
		{
			if (attacker.getIsFriendly() == ((Attackable) foes[i]).getIsFriendly())
				remove(foes, i--); // Preventing enemies/players attack themselves && the minus guarantees all Attackables are checked
		}
		
		return foes;
	}
	
	private Attackable[] getAttackablesInside() {
		
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

	/**
	 * Retorna todos os atacáveis que são do tipo de amigável dado
	 * 
	 * @todo implementar método inteiro
	 */
	public Attackable[] getAttackablesInside(boolean friendlyType)
	{
		return null;
	}

}
