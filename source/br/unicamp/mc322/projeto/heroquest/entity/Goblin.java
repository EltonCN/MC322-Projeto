package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.ChaseMovement;

public class Goblin extends Enemy
{
    /**
     * Operation Goblin
     * Construtor de Goblin (DEVE: definir o movimento básico como Chase, e o ataque
     *
     * @return
     */
    public Goblin (Pose pose) {
    	super(pose, 2, 2, 2); // Balanceamento escolhido: fraco genérico
    	basicMovement = new ChaseMovement();
    }

    @Override
	public void draw() {
		// TODO Auto-generated method stub

	}


}
