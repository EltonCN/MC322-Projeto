package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao requisitar um serviço não disponível
 */
/**
 * @todo Definir superclasse ideal e criar todos os construtores padrão
 */
public class NotAvaibleServiceException extends ServiceException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6604135569482582619L;

	public NotAvaibleServiceException(String s)
    {
        super(s);
    }

    public NotAvaibleServiceException(String message, Exception e) 
    {
        super(message, e);
	}
}

