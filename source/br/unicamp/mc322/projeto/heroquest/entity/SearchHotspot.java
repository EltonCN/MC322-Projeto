package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.item.Treasure;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;
import br.unicamp.mc322.projeto.heroquest.utility.EnemyDice;
import br.unicamp.mc322.projeto.heroquest.utility.RandomPose;

public class SearchHotspot extends HeroQuestEntity implements Interactable {
	
	public SearchHotspot(Pose pose) {
		super(pose);
		//bad = ; @todo implementar pegar inimigo em algum lugar
	}

	@Override
	public void interact(Entity activator) {
		int odds = D6Dice.getResult();
		if (odds < 5)
			invokeTreasure();
		else
			invokeMonster();
	}
	
	private void invokeMonster() {
		invokeEntity(EnemyDice.getEnemy(getUniquePose()));
	}
	
	private void invokeTreasure() {
		invokeEntity(new Treasure(getUniquePose()));
	}
	
	private void invokeEntity(Entity e) {		
		try {
			EntityStoreService s = (EntityStoreService) ServiceManager.getInstance().getService(ServiceType.ENTITYSTORE);
			s.store(e);
		} catch (NotAvaibleServiceException | DisabledServiceException | DisabledEntityException e1) {
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "SearchHotspot", "Falha em instanciar entidade necessária: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private Pose getUniquePose() {
		Entity[] entities = new EntityRangeArea().getEntitiesInside();
		
		boolean unique = false;
		Pose p = RandomPose.getResult();
		
		while(!unique) {
			unique = true;
			
			
			for(int i = 0; i < entities.length; i++) {
				if (entities[i].getPose().equals(p))
					unique = false;
			}
			
			p = RandomPose.getResult();
			
		}
		
		return p;
	}

}
