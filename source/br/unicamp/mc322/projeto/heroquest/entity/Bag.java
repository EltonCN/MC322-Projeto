package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.action.Lootable;
import br.unicamp.mc322.projeto.heroquest.action.Looter;
import br.unicamp.mc322.projeto.heroquest.item.Item;

public class Bag extends HeroQuestEntity implements Lootable {
    /**
     * Operation Bag Construtor de bag
     *
     * @param pose      - Pose da Bag
     * @param inventory - Itens que a Bag contém
     * @return
     */
    @SuppressWarnings("unchecked")
	public Bag (Pose pose, LinkedList<Item> inventory) {
    	super(pose);
    	this.inventory = (LinkedList<Item>) inventory.clone();
    	try {
			LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
			l.sendLog(LogType.OTHER, LogPriority.WARNING, "Bag", "Unchecked Exception: clone method called");
		} catch (NotAvaibleServiceException e) {
			e.printStackTrace();
		} catch (DisabledServiceException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void toBeLooted(Looter activator) {
		activator.loot(inventory);
		disable();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
