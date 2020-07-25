package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;

public class MagicSkeleton extends Enemy implements Caster {
    /**
     * Operation MagicSkeleton
     * Construtor de MagicSkeleton
    (DEVE: definir o ataque básico como MagicMissile o)
     *
     * @return 
     */
    public MagicSkeleton(Pose pose) {
    	super(pose, 4, 4, 2); // Balanceamento escolhido: focado em ataque
    	basicMovement = new RandomMovement();
    	basicAttack = null; //TODO
    }
    
    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

