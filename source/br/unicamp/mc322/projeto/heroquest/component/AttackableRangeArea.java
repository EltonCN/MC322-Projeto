package br.unicamp.mc322.projeto.heroquest.component;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;

/**
 * Representa uma área de alcance de ataque
 */
public class AttackableRangeArea {
	
	EntityRangeArea area;
	
	// Em alguns casos, é interessante acessar todos os atacáveis do estágio
	public AttackableRangeArea() {
		area = new EntityRangeArea(new Pose(0, 0, 0), Integer.MAX_VALUE, Metric.MANHATTAN);
	}
	
	public AttackableRangeArea(Pose origin, float range, Metric metric)
	{
		area = new EntityRangeArea(origin, range, metric);
	}

	private void remove(Attackable[] at, int i) {
		for (int j = i; j < at.length - 1; j++) {
			if (at[j] == null)
				break;
			at[j] = at[j + 1];
		}
	}
	
	
	/**
	 * Retorna todos os atacáveis que não são do tipo do atacante, ie, todos que ele pode atacar
	 * 
	 * @todo implementar método inteiro
	 */
	public Attackable[] getAttackablesInside(Attacker attacker) {
		return getAttackablesInside(!attacker.getIsFriendly()); // Previne aliados de se atacarem
	}
	
	/**
	 * Retorna todos os atacáveis que são do tipo de amigável dado
	 * 
	 * @todo implementar método inteiro
	 */
	public Attackable[] getAttackablesInside(boolean isFriendly) {
		Attackable[] foes = getAttackablesInside();
		for(int i = 0; i < foes.length; i++) 
		{
			try {
				if (isFriendly != ((Attackable) foes[i]).getIsFriendly())
					remove(foes, i--); // O -- garante que todos os atacáveis serão visitados no for
			} catch (NullPointerException e) {
				break;
			}
		}
		
		return foes;
	}
	
	private Attackable[] getAttackablesInside() {
		
		Entity[] entities = area.getEntitiesInside();
		Attackable[] attackables = new Attackable[225]; // @todo TODO mudar 225 para uma cte de estágio
		int added = 0;
		
		for(int i = 0; i < entities.length; i++) {
			try {
				attackables[added++] = (Attackable) entities[i];
			} catch (ClassCastException e) {
				added--; // O -- garante que todos os atacáveis serão visitados no for
			}
		}
		return attackables;
	}

}
