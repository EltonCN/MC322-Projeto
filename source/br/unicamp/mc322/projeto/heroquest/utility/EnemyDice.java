package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
import br.unicamp.mc322.projeto.heroquest.entity.*;

/**
 * 
 * Serve para criação de inimigos aleatória
 *
 */

public class EnemyDice
{
    private static RandomGenerator rand = new RandomGenerator(3);

    public static Enemy getEnemy()
    {
        return getEnemy(new Pose(0,0));
    }

    public static Enemy getEnemy(Pose pose) 
    {
		switch(rand.getResult())
        {
            case 1:
                return new MagicSkeleton(pose);
            case 2:
                return new Skeleton(pose);
            case 3:
                return new Goblin(pose);
            default:
                return null; //Código inalcançável (se RandomGenerator funciona)
        }
	}
}