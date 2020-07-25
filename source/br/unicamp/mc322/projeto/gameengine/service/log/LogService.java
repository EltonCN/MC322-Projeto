package br.unicamp.mc322.projeto.gameengine.service.log;

import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;

public interface LogService extends Service
{
    /**
     * Operation sendLog
     *
     * @param logType - 
     * @param priority - 
     * @param subject - Assunto/Resumo do log
     * @param message - 
     * @throws DisabledServiceException caso o serviço tenha sido desabilitado
     */
    public void sendLog ( LogType logType, LogPriority priority, String subject, String message ) throws DisabledServiceException;

}

