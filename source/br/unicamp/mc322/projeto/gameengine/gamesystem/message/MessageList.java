package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public class MessageList

{
    /** Attributes */
    /**
     * Tipo de mensagem que a lista gerencia
     */
    private MessageType messageType;
    /**
     * Mensagens armazenadas
     */
    private LinkedList<Message> message;


    /**
     * Construtor de MessageList
     * 
     * @param type - tipo de mensagens que a lista irá conter
     */
    public MessageList(MessageType type)
    {
        messageType = type;
    }

    /**
     * Operation sendMessage
     * Envia uma mensagem
     *
     * @param message - Mensagem a ser enviada
     */
    public void sendMessage ( Message message)
    {
        this.message.add(message);
    }
    
    /**
     * Operation clear
     * Limpa a lista
     * @return 
     */
    public void clear (  )
    {  
        message = new LinkedList<Message>();
    }

    /**
     * Retorna as mensagens disponíveis para uma entidade
     * @param entity - entidade que receberá as mensagens
     * @return LinkedList<Message>
     */
    public LinkedList<Message> getMessages(Entity entity,  MessageType type)
    {
        if(type != this.messageType)
        {
            return null;
        }

        LinkedList<Message> mail = new LinkedList<Message>();

        for(Message message:this.message)
        {
            if(message.inRange(entity))
            {
                mail.add(message);
            }
        }

        return message;
    }

    
    /**
     * Operation sendMessage
     * 
     * 
     * @param message - mensagens que serão enviadas 
     */
    public void sendMessage ( LinkedList<Message> message )
    {
        message.addAll(message);
    }

    /**
     * Retorna o tipo de mensagem da lista
     */
    public MessageType getType() 
    {
		return this.messageType;
	}
}

