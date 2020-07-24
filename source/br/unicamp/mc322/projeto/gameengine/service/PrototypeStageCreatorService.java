package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.InvalidStageIdentifierException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

import java.util.Vector;

public class PrototypeStageCreatorService implements StageCreatorService
{
    /** Attributes */
    /**
     * Conjunto de protótipos de estágio existentes
     */
    private Vector<StagePrototype> stageList;

    /**
     * Armazena se o serviço foi encerrado
     */
    private boolean ended;

    public PrototypeStageCreatorService()
    {
        this.ended = false;

        stageList = new Vector<StagePrototype>();
    }

    /**
     * Operation insertStagePrototype
     * Insere um novo protótipo de estágio
     *
     * @param stagePrototype - Protótipo de estágio a ser inserido
     */
    public void insertStagePrototype ( StagePrototype stagePrototype ) throws DisabledServiceException
    {
        if(ended)
        {
            sendDisabledMessage("insertStagePrototype");

            throw new DisabledServiceException("Serviço desabilitado");
        }

        this.stageList.add(stagePrototype);
    }

    @Override
    public void end() 
    {
        ended = true;

    }

    @Override
    /**
     * Carrega um estágio
     */
  
    public void loadStage(StageIdentifier identifier) throws DisabledServiceException, InvalidStageIdentifierException
    {
        if(ended)
        {
            sendDisabledMessage("loadStage");

            throw new DisabledServiceException("Serviço desabilitado");
        }

        StagePrototype prototype;
        try
        {
            prototype = (StagePrototype) identifier;

            

        }
        catch(ClassCastException e)
        {
            throw new InvalidStageIdentifierException("Essa implementação do serviço só funciona com StagePrototype", e);
        }

        if(stageList.contains(prototype) == false)
        {
            throw new InvalidStageIdentifierException("O estágio não foi fornecido ao serviço");
        }

        unload();
        
        prototype.load();

    }

    @Override
    /**
     * @todo criar e lançar exceção para caso não exista um EntityStoreService
     */
    public void unload() throws DisabledServiceException
    {
        if(ended)
        {
            sendDisabledMessage("unload");

            throw new DisabledServiceException("Serviço desabilitado");
        }

        ServiceManager m = ServiceManager.getInstance();
        EntityStoreService s = null;
        try
        {
            s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);
        }
        catch(NotAvaibleServiceException e)
        {
            
        }
        
        for(int i = 0; i<s.countEntity(); i++)
        {
            Entity e = s.getEntity(i);
            
            e.changeStage();

            if(e.isPermanent() == false)
            {
                e.disable();
                s.removeEntity(e);
            }
        }


    }
    
    private void sendDisabledMessage(String methodName)
    {
        ServiceManager m = ServiceManager.getInstance();

      try
        {
            LogService s = (LogService) m.getService(ServiceType.LOG);
            
            s.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "Serviço Desabilitado", "Tentativa de uso de método "+methodName+"() de PrototypeStageCreatorService desativado");
        }
        catch(ServiceException e)
        {
            
        }
    }
}

