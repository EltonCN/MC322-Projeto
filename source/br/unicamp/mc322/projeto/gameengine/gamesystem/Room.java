package br.unicamp.mc322.projeto.gameengine.gamesystem;

import java.util.LinkedList;
import java.util.ArrayList;

import br.unicamp.mc322.projeto.gameengine.entity.EntityType;
import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.gamesystem.Room;
import br.unicamp.mc322.projeto.gameengine.entity.Portal;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;

public class Room

{
    /** Attributes */
    /**
     * Entidades instanciadas dentro da sala
     */
    private LinkedList<Entity> entity;

    /**
     * Portais dentro da sala
     */
    private ArrayList<Portal> portal;

    /**
     * Conjunto de entidades que a sala irá conter quando for iniciada
     */
    private ArrayList<EntityType> entityType;
    
    /**
     * Conjunto poses iniciais das entidades
     */
    private ArrayList<Pose> firstPose;

    /**
     * Conjunto nomes 
     */
    private ArrayList<String> name;

    /**
     * Operation Room
     * Construtor de Room
     *
     */
    public Room()
    {
        this.entity = new LinkedList<Entity>();
        this.entityType = new ArrayList<EntityType>();
        this.firstPose = new ArrayList<Pose>();
        this.name = new ArrayList<String>();
    }
    
    /**
     * Operation run
     * Executa um ciclo da sala
     *
     */
    public void run (  )
    {
        for(Entity current : entity)
        {
            current.run();
        }
    }
    /**
     * Operation show
     * Retorna os sprites buffers da sala
     *
     * @return LinkedList<SpriteBuffer>
     */
    public LinkedList<SpriteBuffer> show (  )
    {
        LinkedList<SpriteBuffer> buffer = new LinkedList<SpriteBuffer>();

        for(Entity current : entity)
        {
            buffer.add(current.show());
        }

        return buffer;
    }
    /**
     * Operation instantiateEntity
     * Instancia as entidades da sala
     *
     */
    public void instantiateEntity (  )
    {
        for(int i = 0; i<entityType.size(); i++)
        {
            Entity newEntity = entityType.get(i).create(name.get(i), firstPose.get(i));


            this.entity.add(newEntity);
        }

        this.entityType = null;
        this.firstPose = null;
    }
    /**
     * Operation insertEntity
     * Define uma entidade que será instanciada quando a sala for iniciada
     *
     * @param entityType - Tipo das entidades a serem instanciadas
     * @param pose - Poses iniciais das entidades
     * @param name - Nome das entidades
     */
    public void insertEntity ( EntityType[] entityType, Pose[] pose , String name[])
    {
        for(int i = 0; i<entityType.length; i++)
        {
            this.entityType.add(entityType[i]);
            this.firstPose.add(pose[i]);
            this.name.add(name[i]);
        }
        
    }
    /**
     * Operation insertEntity
     * Define uma entidade que será instanciada quando a sala for iniciada
     *
     * @param entityType - Tipo da entidade a ser instanciada
     * @param pose - Pose inicial da entidade
     * @param name - Nome da entidade
     */
    public void insertEntity ( EntityType entityType, Pose pose, String name)
    {
        this.entityType.add(entityType);
        this.firstPose.add(pose);
        this.name.add(name);
    }
    /**
     * Operation hasPlayer
     * Verifica se existem jogadores nessa sala
     *
     * @return boolean
     * 
     * @todo Abordagem para implementar Room:hasPlayer
     */
    
    public boolean hasPlayer (  )
    {
        return true;
    }
    /**
     * Operation nextRoom
     * Retorna a próxima sala a ser executada
     *
     * @return Room
     * 
     * @todo Abordagem para implementar Room:nextRoom
     */
    public Room nextRoom (  )
    {
        return null;
    }
}

