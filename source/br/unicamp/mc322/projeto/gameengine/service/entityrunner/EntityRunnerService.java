package br.unicamp.mc322.projeto.gameengine.service.entityrunner;

import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

/**
 * Serviço executor em loops de entidades
 */
public interface EntityRunnerService extends Service
{
    /**
     * Operation run
     * Executa um ciclo
     *
     * @return 
     * @throws NotAvaibleServiceException
     */
    public void run (  ) throws DisabledServiceException, NotAvaibleServiceException;

}

