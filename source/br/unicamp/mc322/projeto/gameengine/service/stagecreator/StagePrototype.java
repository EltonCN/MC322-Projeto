package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;


import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public class StagePrototype extends StageMemento implements StageIdentifier
{
    /** Attributes */
    /**
     * Cópia do estágio modificado após descarregá-lo
     */
    protected StageMemento memento;


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
                Entity entity;

                try
                {
                    entity = s.getEntity(i);
                }
                catch(DisabledEntityException e)
                {
                    continue;
                }
                
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

    @Override
    public Stage getStage()
    {
        return this;
    }
}

