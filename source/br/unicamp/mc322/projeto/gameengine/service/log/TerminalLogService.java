package br.unicamp.mc322.projeto.gameengine.service.log;

import java.time.LocalDateTime;

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

        System.out.println(getTime()+" "+log);

    }

    /**
     * Retorna o tempo atual
     */
    private String getTime()
    {
        LocalDateTime now = LocalDateTime.now();

        String dia = Integer.toString(now.getDayOfMonth()) + "/";

        dia += Integer.toString(now.getMonthValue())+"/";

        dia += Integer.toString(now.getYear());

        String time = Integer.toString(now.getHour())+":";
        time += Integer.toString(now.getMinute())+":";
        time += Integer.toString(now.getSecond())+":";

        return dia+" - "+time;
    }
}

