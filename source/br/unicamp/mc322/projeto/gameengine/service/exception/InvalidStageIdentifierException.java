package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada quando um identificador de estágio não for válido
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class InvalidStageIdentifierException extends Exception
{
    public InvalidStageIdentifierException(String s)
    {
        super(s);
    }

    public InvalidStageIdentifierException(Exception e)
    {
        super(e);
    }

    public InvalidStageIdentifierException(String string, Exception e) 
    {
        super(string, e);
	}
}

