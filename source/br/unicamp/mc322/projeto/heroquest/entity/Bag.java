package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.HeroQuestEntity;
import br.unicamp.mc322.projeto.heroquest.entity.Interactable;

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
    public Bag ( Pose pose, LinkedList<Item> inventory ){}
}

