package br.unicamp.mc322.projeto.gameengine.component;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;

public class Direction extends Area {


	private Comparator<Entity> comp = new Comparator<Entity>() {
		public int compare(Entity e1, Entity e2) {
			float r1 = origin.distance(e1.getPose(), metric);
			float r2 = origin.distance(e2.getPose(), metric);
			
			if (r1 < r2) return -1;
			else if (r1 > r2) return 1;
			else return 0;
		}

	};
	
	public Direction(Pose origin, float range, Metric metric) {
		super(origin, range, metric);
	}
	
	public Direction(Pose origin, Metric metric) {
		super(origin, Integer.MAX_VALUE, metric);
		//Infinite direction
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
			
		} catch (NotAvaibleServiceException | DisabledServiceException e) {
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.ENTITYSTORE, LogPriority.ERROR, "SearchHotspot", "Há um problema: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
		}
		
		return new Entity[0];
	}
	
	public Entity[] getEntitiesInDirectionInOrder() {
		Entity[] entities = getEntitiesInDirection();
		LinkedList<Entity> sortedEntities = new LinkedList<Entity>();
		for(int i = 0; i <  entities.length; i++) {
			sortedEntities.add(entities[i]);
		}
		
		Collections.sort(sortedEntities, comp);
		
		return (Entity[]) sortedEntities.toArray();
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
