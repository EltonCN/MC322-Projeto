package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageManager;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageList;

public class MessageManager

{
    /** Attributes */
    /**
     * Listas de mensagens gerenciadas
     */
    private MessageList[] messageList;
    /**
     * Instância única do MessageManager
     */
    private static MessageManager instance;
    /** Associations */
    private MessageList unnamed_10;
    /**
     * Operation sendMessage
     * Envia uma mensagem por uma lista
     *
     * @param message - Mensagem que será enviada
     */
    public void sendMessage ( Message message ){}
    /**
     * Operation getInstance
     * Retorna a instância atual de MessageManager
     *
     * @return MessageManager
     */
    public static MessageManager getInstance() {
    	if (instance == null)
    		instance = new MessageManager();
    	return instance;
    }
    /**
     * Operation clear
     * Limpa a lista de mensagens
     *
     */
    public void clear (  ){}
    /**
     * Operation sendMessage
     * Envia um conjunto de mensagens
     *
     * @param message - 
     * @return 
     */
    public sendMessage ( LinkedList<Message> message ){}
    /**
     * Operation MessageManager
     * Construtor de MessageManager
     *
     * @return 
     */
    private MessageManager (  ){}
	public LinkedList<Message> getMessages(Entity entity, BasicMessageType type) {
		// TODO Auto-generated method stub
		return null;
	}
}

