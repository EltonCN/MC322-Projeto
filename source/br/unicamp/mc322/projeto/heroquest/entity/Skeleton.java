package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;
import br.unicamp.mc322.projeto.heroquest.entity.Enemy;

public class Skeleton extends Enemy
{
    /**
     * Operation Skeleton
     * Construtor de esqueleto (DEVE: definir o movimento básico como Random, e o ataque básico como uma arma aleatória)
     *
     * @return 
     */
    public Skeleton (Pose pose  )
    {
        super(pose);
        this.basicMovement = new RandomMovement();
        this.basicAttack = ???;
    }
}

