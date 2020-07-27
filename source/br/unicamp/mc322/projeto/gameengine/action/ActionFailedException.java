package br.unicamp.mc322.projeto.gameengine.action;


public class ActionFailedException extends Exception

{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6596316614139923040L;

	public ActionFailedException(String s)
    {
        super(s);
    }

    public ActionFailedException(String s, Exception e)
    {
        super(s, e);
    }
}

