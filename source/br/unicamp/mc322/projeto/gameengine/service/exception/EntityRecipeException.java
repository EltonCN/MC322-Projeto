package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao não conseguir instanciar uma entidade
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class EntityRecipeException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7626673779498383468L;

	public EntityRecipeException(String s)
    {
        super(s);
    }

    public EntityRecipeException(Exception e)
    {
        super(e);
    }

    public EntityRecipeException(String string, Exception e) 
    {
        super(string, e);
	}
}

