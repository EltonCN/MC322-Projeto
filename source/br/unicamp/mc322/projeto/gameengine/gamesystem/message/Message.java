package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageType;
import br.unicamp.mc322.projeto.gameengine.entity.EntityType;
import br.unicamp.mc322.projeto.game.entity.HeroQuestEntityType;
import br.unicamp.mc322.projeto.gameengine.Metric;
import br.unicamp.mc322.projeto.gameengine.Pose;

public abstract class Message

{
    /** Attributes */
    /**
     * A entidade emissora da mensgem
     */
    private Entity emitter;

    /**
     * Texto que representa o que a mensagem faz
     */
    private String text;

    /**
     * Tipo da entidade emissora
     */
    private EntityType entityType;

    /**
     * Pose enviada na mensagem
     */
    private Pose pose;

    /**
     * Alcance enviado na mensagem
     */
    private float range;

    /**
     * Tipo da mensagem sendo enviada
     */
    private MessageType type;

    /**
     * Operation Message
     * Construtor de Message
     *
     * @param emitterEntity - Entidade emissora da mensagem
     * @param text - Texto que representa a mensagem
     * @return 
     */
    public Message ( Entity emitterEntity, String text )
    {
        this.emitter = emitterEntity;
        this.text = text;
    }

    /**
     * Operation getType
     * Retorna o tipo da entidade emissora
     *
     * @return EntityType
     * 
     * @todo Retornar o tipo da entidade
     */
    public MessageType getMessageType (  )
    {
        return type;
    }

    /**
     * Operation getType
     * Retorna a pose da mensagem
     *
     * @return Pose
     */
    public Pose getPose (  )
    {
        return pose;
    }

    /**
     * Verifica se a entidade está dentro do alcance da mensagem
     * 
     * @param entity - entidade que será verificada
     * @return booelan
     */
    public boolean inRange(Entity entity)
    {
        if(entity.distance(pose, Metric.EUCLIDEAN) <= range)
        {
            return true;
        }
        return false;
    }

}

