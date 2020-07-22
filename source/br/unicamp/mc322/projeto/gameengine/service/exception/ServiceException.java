package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao realizar operações não possíveis com serviços
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class ServiceException extends Exception
{
    public ServiceException(String s)
    {
        super(s);
    }

    public ServiceException(String string, Exception e) 
    {
        super(string, e);
	}
}

