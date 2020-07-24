package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;

public interface Attack extends Action
{
    public static Metric metric = Metric.EUCLIDEAN;

    /**
     * Executa o ataque com um objetivo específico
     */
    public void run ( Entity origin, Attackable target ) throws ActionFailedException;

}

