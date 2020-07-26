package br.unicamp.mc322.projeto.heroquest.component;

import java.util.Vector;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;

import br.unicamp.mc322.projeto.heroquest.entity.Interactable;

public class InteractableRangeArea {
	
EntityRangeArea area;
	
	public InteractableRangeArea(Pose origin, float range, Metric metric) {
		area = new EntityRangeArea(origin, range, metric);
	}

	public InteractableRangeArea() {
		area = new EntityRangeArea(new Pose(0, 0, 0), Integer.MAX_VALUE, Metric.MANHATTAN);
	}
	
	
	public Vector<Interactable> getInteractablesInside() {
		
		Entity[] entities = area.getEntitiesInside();
		Vector<Interactable> interectables = new Vector<Interactable>();
		
		for(int i = 0; i < entities.length; i++) 
		{
			try 
			{
				interectables.add( (Interactable) entities[i] );
			} catch (ClassCastException e) 
			{
			}
		}
		return interectables;
	}

}
