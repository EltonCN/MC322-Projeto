package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.item.Item;

public class Bag extends HeroQuestEntity implements Interactable
{
    /**
     * Operation Bag
     * Construtor de bag
     *
     * @param pose - Pose da Bag
     * @param inventory - Itens que a Bag contém
     * @return 
     */
    public Bag (Pose pose, LinkedList<Item> inventory) {
    	super(pose);
    	inventory = new LinkedList<Item>();
    }

	@Override
	public void interact(Entity activator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

