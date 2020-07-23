package br.unicamp.mc322.projeto.gameengine.service;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.EntityRecipeException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;

public class StageMemento
{
    /** Attributes */
    /**
     * Protótipos das entidades no estágio
     */
    private LinkedList<EntityPrototype> entityPrototype;
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

                    log.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "Entidade não pode ser instanciada", e.getMessage());
                }
                catch(ServiceException e2)
                {
                    
                }
            }
            
            try
            {
                store.store(entity);
            }
            catch(DisabledServiceException e)
            {

            }
            
        }
    }
}

