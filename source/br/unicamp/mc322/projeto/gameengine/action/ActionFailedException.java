package br.unicamp.mc322.projeto.gameengine.action;


public class ActionFailedException extends Exception

{
    public ActionFailedException(String s)
    {
        super(s);
    }

    public ActionFailedException(String s, Exception e)
    {
        super(s, e);
    }
}

