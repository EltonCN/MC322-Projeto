package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;

public class MessageList

{
    /** Attributes */
    /**
     * Tipo de mensagem que a lista gerencia
     */
    private messageType messageType;
    /**
     * Entidades inscritas
     */
    private Entity[] subscriber;
    /**
     * Mensagens armazenadas
     */
    private Message[] message;
    /** Associations */
    private Message unnamed_14;
    /**
     * Operation sendMessage
     * Envia uma mensagem
     *
     * @param message - Mensagem a ser enviada
     */
    public void sendMessage ( Message message ){}
    /**
     * Operation clear
     *
     * @return 
     */
    public clear (  ){}
    /**
     * Operation sendMessage
     *
     * @param message - 
     * @return 
     */
    public sendMessage ( LinkedList<Message> message ){}
}

