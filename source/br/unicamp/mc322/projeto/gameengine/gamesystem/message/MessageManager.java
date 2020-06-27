package br.unicamp.mc322.projeto.gameengine.gamesystem.message;

import java.util.LinkedList;
import java.util.ArrayList;

import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageManager;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.MessageList;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public class MessageManager

{
    /** Attributes */
    /**
     * Listas de mensagens gerenciadas
     */
    private ArrayList<MessageList> messageList;
    /**
     * Instância única do MessageManager
     */
    private static MessageManager instance;

    /**
     * Operation sendMessage
     * Envia uma mensagem por uma lista
     *
     * @param message - Mensagem que será enviada
     */
    public void sendMessage ( Message message )
    {
        for(MessageList list : messageList)
        {
            if(list.getType() == message.getMessageType())
            {
                list.sendMessage(message);
                return;
            }
        }

        MessageList newList = new MessageList(message.getMessageType());

        newList.sendMessage(message);

        messageList.add(newList);
    }
    /**
     * Operation getInstance
     * Retorna a instância atual de MessageManager
     *
     * @return MessageManager
     */
    public MessageManager getInstance (  )
    {
        if(instance == null)
        {
            instance = new MessageManager();
        }

        return instance;
    }
    /**
     * Operation clear
     * Limpa a lista de mensagens
     *
     */
    public void clear (  )
    {
        for(MessageList list : messageList)
        {
            list.clear();
        }
    }

    /**
     * Operation sendMessage
     * Envia um conjunto de mensagens
     *
     * @param message - 
     * @return 
     */
    public void sendMessage ( LinkedList<Message> message )
    {
        for(Message m : message)
        {
            boolean sended = false;

            for(MessageList list : messageList)
            {
                if(list.getType() == m.getMessageType())
                {
                    list.sendMessage(message);

                    
                }
            }
            
            if(sended == false)
            {
                MessageList newList = new MessageList(m .getMessageType());

                newList.sendMessage(m);

                messageList.add(newList);
            }

            message.remove(m);
        }


    }

    /**
     * Retorna as mensagens disponíveis para uma entidade
     * @param entity
     * @param message
     */
    public LinkedList<Message> getMessage(Entity entity, MessageType type)
    {
        LinkedList<Message> mail = new LinkedList<Message>();

        for(MessageList list : messageList)
        {
            mail.addAll(list.getMessages(entity, type));

        }

        return mail;
    }

    /**
     * Operation MessageManager
     * Construtor de MessageManager
     *
     * @return 
     */
    private MessageManager (  ){}
}

