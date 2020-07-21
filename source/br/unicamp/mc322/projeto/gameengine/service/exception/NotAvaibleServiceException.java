package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao requisitar um serviço não disponível
 */
/**
 * @todo Definir superclasse ideal e criar todos os construtores padrão
 */
public class NotAvaibleServiceException extends Exception
{
    public NotAvaibleServiceException(String s)
    {
        super(s);
    }
}

