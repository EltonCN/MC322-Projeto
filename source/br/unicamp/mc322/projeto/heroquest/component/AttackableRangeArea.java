package br.unicamp.mc322.projeto.heroquest.component;

import java.util.Vector;

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
		Vector<Attackable> foes = getAttackablesInside();
		for(int i = 0; i < foes.size(); i++) 
		{
			try {
				if (isFriendly != ((Attackable) foes.get(i)).getIsFriendly())
					foes.remove( i--); // O -- garante que todos os atacáveis serão visitados no for
			} catch (NullPointerException e) {
				break;
			}
		}
		
		return foes.toArray(new Attackable[foes.size()]);
	}
	
	private Vector<Attackable> getAttackablesInside() {
		
		Entity[] entities = area.getEntitiesInside();
		Vector<Attackable> attackables = new Vector<Attackable>();
		
		for(int i = 0; i < entities.length; i++) 
		{
			try 
			{
				attackables.add( (Attackable) entities[i] );
			} catch (ClassCastException e) 
			{
			}
		}
		return attackables;
	}

}
