package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Attack;

public class SimpleAttack
 implements Attack
{
    /** Attributes */
    /**
     * Dano do ataque
     */
    private float damage;
    /**
     * Alcance do ataque
     */
    private float reach;
    /**
     * Operation SimpleAttack
     * Construtor de SimpleAttack
     *
     * @param damage - Dano do ataque
     * @param reach - Alcance do ataque
     * @return 
     */
    public SimpleAttack ( float damage, float reach ){}
	@Override
	public void run(Entity origin) {
		// TODO Auto-generated method stub
		
	}
}

