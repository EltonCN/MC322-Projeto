package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.RandomChaseMovement;
import br.unicamp.mc322.projeto.heroquest.magic.Magic;
import br.unicamp.mc322.projeto.heroquest.magic.MagicMissile;

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
    	basicMovement = new RandomChaseMovement();
    	basicAttack = new MagicMissile();
    }
    
    @Override
	public void draw() {
		///@todo Auto-generated method stub
	}
    
    @Override
	public Magic getMagic(int i) {
		return (Magic) basicAttack;
	}

	@Override
	public int getNMagics() {
		return 1;
	}
	
	@Override
	public void runMagics() {
		return;
	}
}

