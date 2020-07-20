package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.LogType;
import br.unicamp.mc322.projeto.gameengine.service.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.Service;

public interface LogService
 implements Service
{
    /**
     * Operation sendLog
     *
     * @param logType - 
     * @param priority - 
     * @param subject - Assunto/Resumo do log
     * @param message - 
     */
    public void sendLog ( LogType logType, LogPriority priority, String subject, String message );

}

