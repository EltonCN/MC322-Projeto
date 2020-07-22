package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;

/**
 * Serviço de Logging pelo terminal
 */
public class TerminalLogService implements LogService
{
    private boolean ended;

    /**
     * Construtor de TerminalLogService
     * 
     * Define o serviço como não terminado
     */
    public TerminalLogService()
    {
        ended = false;
    }

    @Override
    public void end() {
        this.ended  = true;

    }

    @Override
    public void sendLog(LogType logType, LogPriority priority, String subject, String message) throws DisabledServiceException
    {
        if(this.ended == true)
        {
            throw new DisabledServiceException("Tentativa de uso de serviço de logging desativado");
        }

        String log = "["+priority.toString()+"]: ";


        log += logType.toString()+ " ";

        log += "(" + subject+ ") - ";

        log += message;

        System.out.println(log);

    }
}

