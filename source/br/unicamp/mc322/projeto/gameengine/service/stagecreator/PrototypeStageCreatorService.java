package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
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

    private StageIdentifier actualStage;

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
    public void insertStage( StagePrototype stagePrototype ) throws DisabledServiceException
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
        
        actualStage = identifier;

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
        	try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "PrototypeStageCreatorService", "Há um problema: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
        }
        
        for(int i = 0; i<s.countEntity(); i++)
        {
            Entity e = null;
            try
            {
                e = s.getEntity(i);
            }
            catch(DisabledEntityException ex)
            {
                continue;
            }
            
            
            e.stageChanged();

            if(e.isPermanent() == false)
            {
                e.disable();
                s.removeEntity(e);
            }
        }

        if(actualStage == null)
        {
            return;
        }

        StagePrototype stage = (StagePrototype) actualStage.getStage();
        stage.createMemento();
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

    @Override
    /**
     * 
     */
    public void insertStage(Stage stage) 
    {
    	try {
        stageList.add((StagePrototype) stage);
    	} catch (ClassCastException e) {
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "PrototyoeStageCreatorService", "Há um problema (" + e + "): tentativa de inserir um estágio que não compatível com o serviço implementado");
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
    	}

    }
}

