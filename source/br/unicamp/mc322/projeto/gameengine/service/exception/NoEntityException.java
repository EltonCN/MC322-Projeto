package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada quando o objeto passado não coresponde a classe
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class NoEntityException extends Exception
{
    public NoEntityException(String s)
    {
        super(s);
    }

    public NoEntityException(Exception e)
    {
        super(e);
    }

    public NoEntityException(String string, Exception e) 
    {
        super(string, e);
	}
}

