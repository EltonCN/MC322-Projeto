package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;
import br.unicamp.mc322.projeto.heroquest.entity.Enemy;

public class MagicSkeleton extends Enemy
{
    /**
     * Operation MagicSkeleton
     * Construtor de MagicSkeleton
    (DEVE: definir o ataque básico como MagicMissile o
     *
     * @return 
     */
    public MagicSkeleton(Pose pose)
    {
    	super(pose);
    	basicMovement = new RandomMovement();
    	basicAttack = null; //TODO
    }
}

