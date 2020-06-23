package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;
import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.output.image.Paintable;
import br.unicamp.mc322.projeto.gameengine.item.Item;

public abstract class Entity
 implements Paintable
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
    /** Associations */
    private Item unnamed_5;
    private SpriteBuffer unnamed_2;
    private Pose unnamed_1;
    /**
     * Operation Entity
     * Construtor de entidade
     *
     * @param name - Nome da entidade
     * @param pose - Pose inicial da entidade
     * @return 
     */
    public Entity ( String name , Pose pose)
    {
        
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
    abstract public LinkedList<Entity> kill (  );

    /**
     * Operation run
     * Executa um ciclo da entidade
     *
     * @return 
     */
    abstract public run (  );

    /**
     * Operation adjacent
     * Verifica se outra entidade é adjacente a esta
     *
     * @param entity - Entidade para verificar se é adjacente
     * @return boolean
     */
    public boolean adjacent ( Entity entity );

    /**
     * Operation getMessages
     *
     * @return LinkedList<Message>
     */
    public LinkedList<Message> getMessages (  );

}

