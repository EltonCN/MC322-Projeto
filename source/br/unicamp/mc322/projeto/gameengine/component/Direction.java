package br.unicamp.mc322.projeto.gameengine.component;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

public class Direction extends Area {


	
	public Direction(Pose origin, float range, Metric metric) {
		super(origin, range, metric);
	}
	
	public Direction(Pose origin, Metric metric) {
		super(origin, metric);
		range = Integer.MAX_VALUE; //Infinite direction
	}

	public boolean isInDirection(Pose pose) {
		if (isInside(pose) && isAngleClose((float) Math.toDegrees(Math.atan2(pose.getY() - origin.getY(), pose.getX() - origin.getX()))))
			return true;
		return false;
	}
	
	public Entity[] getEntitiesInDirection() {
		
		try {
			EntityStoreService s = (EntityStoreService) ServiceManager.getInstance().getService(ServiceType.ENTITYSTORE);
			Entity[] range = s.getRange(origin, this.range, metric);
			LinkedList<Entity> entities = new LinkedList<Entity>();
			
			for(int i = 0; i <  range.length; i++) {
				if (isInDirection(range[i].getPose()))
				entities.add(range[i]);
			}
			return (Entity[]) entities.toArray();
			
		} catch (NotAvaibleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DisabledServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Entity[0];
	}
	
	public Entity[] getEntitiesInDirectionInOrder() {
		Entity[] entities = getEntitiesInDirection();
		LinkedList<Entity> sortedEntities = new LinkedList<Entity>();
		for(int i = 0; i <  entities.length; i++) {
			sortedEntities.add(entities[i]);
		}
		return (Entity[]) sortNotThatGood(sortedEntities).toArray();
	}
	
	private int compareEntities(Entity e1, Entity e2) {
		float r1 = origin.distance(e1.getPose(), metric);
		float r2 = origin.distance(e2.getPose(), metric);
		
		if (r1 > r2) return -1;
		else if (r1 < r2) return 1;
		else return 0;
	}
	
	private LinkedList<Entity> sortNotThatGood(LinkedList<Entity> l) {
		for (int i = 0;  i < l.size(); i++) {
			int smaller = i;
			for (int j = i; j <  l.size(); j++) {
				if (compareEntities(l.get(smaller), l.get(j)) == -1)
					smaller = j;
			}
			Entity temp = l.get(i);
			l.set(i, l.get(smaller));
			l.set(smaller, temp);
		}
		return l;
	}
	
	public Entity getEntityInIndex(int i) throws NullPointerException {
		Entity[] entities = getEntitiesInDirectionInOrder();
		if (i > entities.length)
			return entities[entities.length - 1];
		if (entities.length == 0)
			throw new NullPointerException();
		return entities[i];
	}
	
	public Entity getFirstEntityInDirection() {
		return getEntityInIndex(0);
	}
	
	
	

}
