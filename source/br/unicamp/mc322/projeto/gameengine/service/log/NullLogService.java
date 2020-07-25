package br.unicamp.mc322.projeto.gameengine.service.log;

public class NullLogService
 implements LogService
{

    @Override
    public void end() {


    }

    @Override
    public void sendLog(LogType logType, LogPriority priority, String subject, String message) {

    }
}

