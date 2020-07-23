package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityPrototype;
import br.unicamp.mc322.projeto.heroquest.action.ChaseMovement;
import br.unicamp.mc322.projeto.heroquest.entity.Enemy;

public class Goblin extends Enemy
{
    /**
     * Operation Goblin
     * Construtor de Goblin (DEVE: definir o movimento básico como Chase, e o ataque 
     *
     * @return 
     */
    public Goblin (Pose pose) {
    	super(pose);
    	basicMovement = new ChaseMovement();
    }


}

