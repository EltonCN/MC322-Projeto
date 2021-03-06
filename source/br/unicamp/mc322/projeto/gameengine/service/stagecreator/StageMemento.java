package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.EntityRecipeException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;

public class StageMemento implements Stage
{
    /** Attributes */
    /**
     * Protótipos das entidades no estágio
     */
    protected LinkedList<EntityPrototype> entityPrototype;

    public StageMemento()
    {
        this.entityPrototype = new LinkedList<EntityPrototype>();
    }

    /**
     * Operation addPrototype
     * Adiciona um protótipo de entidade no estágio
     *
     * @param entityPrototype - 
     */
    public void addPrototype ( EntityPrototype entityPrototype )
    {
        this.entityPrototype.add(entityPrototype);
    }

    public void addPrototype(LinkedList<EntityPrototype> list)
    {
        entityPrototype.addAll(list);
    }

    /**
     * Operation load
     * Carrega o estágio
     * 
     * @todo Precisa lançar uma exceção caso o StoreService não funcione
     */
    public void load (  )
    {
        ServiceManager m = ServiceManager.getInstance();
        
        EntityStoreService store = null;

        try
        {
            store = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);
        }
        catch(NotAvaibleServiceException e)
        {
        	try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.ENTITYSTORE, LogPriority.ERROR, "EntityStore", "Há um problema: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
        }
       

        for(EntityPrototype prototype : entityPrototype)
        {
            Entity entity = null;
            
            try
            {
                entity = prototype.instantiateEntity();
            }
            catch(EntityRecipeException e)
            {
                try
                {
                    LogService log = (LogService) m.getService(ServiceType.LOG);

                    log.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "StageMemento", e.getMessage());
                }
                catch(ServiceException e2)
                {
                    e2.printStackTrace(); 
                }
            }
            
            try
            {
                store.store(entity);
            }
            catch(DisabledServiceException e)
            {
                ///@todo verificar necessidade de encerrar o programa
            }
            catch(DisabledEntityException e)
            {
                //Faz nada
            }
            
        }
    }
}

