package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.Vector;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.component.InteractableRangeArea;

public interface Interactable

{
    /**
     * Operation interact
     * Interage com a entidade
     *
     * @param activator - Entidade que irá interagir com ela
     */
    public void interact (Entity activator);
    
    public static Interactable[] getInteractablesNear(Player interactor) {
    	Vector<Interactable> interactables = new InteractableRangeArea(interactor.getPose(), 1, Metric.MANHATTAN).getInteractablesInside();
    	return  interactables.toArray(new Interactable[interactables.size()]);
    }

}

