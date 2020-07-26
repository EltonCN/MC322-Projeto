package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao utilizar um serviço desabilitado
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class DisabledServiceException extends ServiceException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6190869166870192206L;

	public DisabledServiceException(String s)
    {
        super(s);
    }
}

