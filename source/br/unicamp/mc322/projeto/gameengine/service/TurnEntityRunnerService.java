package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;

public class TurnEntityRunnerService implements EntityRunnerService 
{
    private boolean ended;

    /**
     * Construtor de TurnEntityRunnerService
     * 
     * Define o serviço como não encerrado
     */
    public TurnEntityRunnerService()
    {
        this.ended = false;
    }

    @Override
    /**
     * Termina o serviço
     */
    public void end() 
    {
        this.ended = true;
    }

    @Override
    /**
     * Executa todas as entidades que possuem turnos
     */
    public void run() throws DisabledServiceException, NotAvaibleServiceException
    {
        ServiceManager m = ServiceManager.getInstance();

        if(this.ended == true)
        {
            try
            {
                
                
                LogService s = (LogService) m.getService(ServiceType.LOG);

                s.sendLog(LogType.ENTITYRUNNER, LogPriority.ERROR, "Tentativa de uso de serviço encerrado", "Tentativa de uso de serviço TurnEntityRunner finalizado");
            }
            catch(ServiceException e)
            {

            }

            throw new DisabledServiceException("Tentativa de uso de serviço TurnEntityRunner finalizado");
        }

        EntityStoreService s;

        try
        {
            s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);
        }
        catch(NotAvaibleServiceException e)
        {
            throw new NotAvaibleServiceException("Não é possível utilizar esse serviço sem um armazenador de entidades", e);
        }

        for(int i = 0; i<s.countEntity(); i++)
        {
            Entity entity = s.getEntity(i);

            try
            {
                RunnableTurn runnableEntity = (RunnableTurn) entity;

                runnableEntity.startTurn();

                while(runnableEntity.isInTurn())
                {
                    runnableEntity.run();
                }
            }
            catch(ClassCastException e)
            {

            }
        }
        
    }   
}

