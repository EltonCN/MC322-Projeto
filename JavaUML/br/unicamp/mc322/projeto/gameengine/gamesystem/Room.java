package br.unicamp.mc322.projeto.gameengine.gamesystem;

import br.unicamp.mc322.projeto.gameengine.entity.EntityType;
import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.gamesystem.Room;
import br.unicamp.mc322.projeto.gameengine.entity.Portal;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

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
    private Portal[] portal;
    /**
     * Conjunto de entidades que a sala irá conter quando for iniciada
     */
    private EntityType[] entityType;
    /** Associations */
    private Portal unnamed_4;
    private Entity unnamed_3;
    /**
     * Operation run
     * Executa um ciclo da sala
     *
     */
    public void run (  ){}
    /**
     * Operation show
     * Retorna os sprites buffers da sala
     *
     * @return LinkedList<SpriteBuffer>
     */
    public LinkedList<SpriteBuffer> show (  ){}
    /**
     * Operation instantiateEntity
     * Instancia as entidades da sala
     *
     */
    public void instantiateEntity (  ){}
    /**
     * Operation insertEntity
     * Define uma entidade que será instanciada quando a sala for iniciada
     *
     * @param entityType - Tipo das entidades a serem instanciadas
     * @param pose - Poses iniciais das entidades
     */
    public void insertEntity ( EntityType[] entityType, Pose[] pose ){}
    /**
     * Operation insertEntity
     * Define uma entidade que será instanciada quando a sala for iniciada
     *
     * @param entityType - Tipo da entidade a ser instanciada
     * @param pose - Pose inicial da entidade
     */
    public void insertEntity ( EntityType entityType, Pose pose ){}
    /**
     * Operation hasPlayer
     * Verifica se existem jogadores nessa sala
     *
     * @return boolean
     */
    public boolean hasPlayer (  ){}
    /**
     * Operation nextRoom
     * Retorna a próxima sala a ser executada
     *
     * @return Room
     */
    public Room nextRoom (  ){}
}

