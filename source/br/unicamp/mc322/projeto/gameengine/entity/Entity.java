package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.Metric;
import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.BasicMessageType;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageManager;
import br.unicamp.mc322.projeto.gameengine.output.image.Paintable;
import br.unicamp.mc322.projeto.gameengine.item.Item;

public abstract class Entity implements Paintable
{
    /** Attributes */
    /**
     * SpriteBuffer atual da entidade
     */
    private SpriteBuffer sprite;
    /**
     * Pose atual da entidade
     */
    private Pose pose;
    /**
     * Nome da entidade
     */
    private String name;
    /**
     * Itens que a entidade contém
     */
    protected LinkedList<Item> inventory;
   
    /**
     * Operation Entity
     * Construtor de entidade
     *
     * @param name - Nome da entidade
     * @param pose - Pose inicial da entidade
     * @return 
     */
    
    public Entity (String name , Pose pose)
    {
        this.name = name;
        this.pose = pose;
        inventory = new LinkedList<Item>();
    }
    
    public Entity (String name , Pose pose, LinkedList<Item> inventory) {
    	this(name, pose);
    	this.inventory = cloneInventory(inventory);
    }
    
    private LinkedList<Item> cloneInventory(LinkedList<Item> items) {
    	LinkedList<Item> inventory = new LinkedList<Item>();
    	for(Item item: items) {
    		inventory.add(item);
    	}
    	return inventory;
    }

    /**
     * Operation alive
     * Verifica se a entidade ainda deve ser executada
     *
     * @return boolean
     */
    abstract public boolean alive (  );

    /**
     * Operation kill
     * Encerra a entidade e retorna outras entidades decorrentes de seu fim
     *
     * @return LinkedList<Entity>
     */
    public abstract LinkedList<Entity> kill (  );
    
    /**
     * Operation run
     * Executa um ciclo da entidade
     *
     * @return boolean - False se o turno da entidade não estiver terminado
     */
    public abstract boolean  run ();

    /**
     * Operation adjacent
     * Verifica se outra entidade é adjacente a esta
     *
     * @param entity - Entidade para verificar se é adjacente
     * @return boolean
     */
    public boolean adjacent (Entity entity) {
    	return entity.pose.adjacent(pose);
    }

    /**
     * Operation getMessages
     *
     * @return LinkedList<Message>
     */
    public LinkedList<Message> getMessages(BasicMessageType type) {
    	return MessageManager.getInstance().getMessages(this, type);
    }

    /**
     * Operation distance
     * 
     * Calcula a distância até uma pose
     * 
     * @param pose2 A outra pose
     * @param metric Métrica a ser utilizada
     * @return float
     */
    public float distance(Pose pose2, Metric metric) 
    {
		return this.pose.distance(pose2, metric);
	}

}

