package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.StageMemento;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.StageIdentifier;

public class StagePrototype extends StageMemento implements StageIdentifier
{
    /** Attributes */
    /**
     * Cópia do estágio modificado após descarregá-lo
     */
    private StageMemento memento;


    public StagePrototype()
    {
        memento = null;
    }

    /**
     * Operation createMemento
     * Cria uma cópia do estágio como está agora na memória
     * 
     * @todo Lidar com exceções
     */
    public void createMemento (  )
    {
        ServiceManager m = ServiceManager.getInstance();
        EntityStoreService s;

        try
        {
            s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            memento = new StageMemento();

            for(int i = 0; i<s.countEntity(); i++)
            {
                Entity entity = s.getEntity(i);
                
                try
                {
                    PrototypableEntity prototyble = (PrototypableEntity) entity;

                    memento.addPrototype(prototyble.createPrototype());

                }   
                catch(ClassCastException e)
                {

                }
            }
        }
        catch(ServiceException e)
        {
            
        }
        
        
    }

    public void load()
    {
        if(memento == null)
        {
            super.load();
        }
        else{
            memento.load();
        }
    }
}

