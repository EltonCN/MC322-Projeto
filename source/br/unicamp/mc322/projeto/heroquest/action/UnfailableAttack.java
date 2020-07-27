package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;



public class UnfailableAttack extends SimpleAttack implements Attack {

	public UnfailableAttack(int damage, float reach) {
		super(damage, reach);
	}

	@Override
	protected void doAttack(Attacker attacker, Attackable target) {
		target.takeDamage(damageBonus);
		
	}

}
