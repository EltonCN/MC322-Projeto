package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.component.LightObstructorArea;
import br.unicamp.mc322.projeto.heroquest.item.Item;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypableEntity;

public abstract class HeroQuestEntity extends Entity implements PrototypableEntity {
    /** Attributes */
    /**
     * Define se a entidade deve ou não obstruir a visão
     */
    private boolean obstructor;
    /**
     * Area obstruidora de luz da entidade
     */
    private LightObstructorArea lightObstructorArea;
    /**
     * Inventário da entidade
     */
    protected LinkedList<Item> inventory;
    
    private static final int INVENTORY_LIMIT = 5;
    /**
     * Operation HeroQuestEntity
     * Construtor de HeroQuestEntity
     *
     * @param pose - Pose da entidade
     * @return 
     */
    public HeroQuestEntity (Pose pose) {
        super(pose);
        inventory = new LinkedList<Item>();
    }

    /**
     * Operation toggleObstructor
     * Alterna a propriedade de obstruir luz da entidade
     *
     * @param visibility -
     */
    public void toggleObstructor(boolean visibility) {
        this.obstructor = visibility;
    }
    
    protected void addItemToInventory(Item item) {
    	if (inventory.size() < INVENTORY_LIMIT)
    		inventory.add(item);
    	else {
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.WARNING, "HeroQuestEntity", "Tentativa de Adicionar item ao inventário falhou: inventário cheio");
			} catch (NotAvaibleServiceException e) {
				e.printStackTrace();
			} catch (DisabledServiceException e) {
				e.printStackTrace();
			}
    	}
    }
    
    protected Item removeItemFromInventory(int i) {
    	return inventory.remove(i);
    }


    @Override
	public EntityPrototype createPrototype() {
		return new EntityPrototype(getClass(), getPose());
	}
}

