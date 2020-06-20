package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageType;
import br.unicamp.mc322.projeto.gameengine.entity.EntityType;

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
    private entityType entityType;
    /**
     * 
     */
    private  pose;
    /**
     * 
     */
    private float range;
    /**
     * Tipo da mensagem sendo enviada
     */
    private MessageType type;
    /** Associations */
    private MessageType unnamed_17;
    /**
     * Operation Message
     * Construtor de Message
     *
     * @param emitterEntity - Entidade emissora da mensagem
     * @param text - Texto que representa a mensagem
     * @return 
     */
    public Message ( Entity emitterEntity, String text );

    /**
     * Operation getType
     * Retorna o tipo da entidade emissora
     *
     * @return EntityType
     */
    public EntityType getType (  );

}

