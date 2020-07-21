package br.unicamp.mc322.projeto.gameengine.service.exception;


/**
 * Exceção lançada ao utilizar um serviço desabilitado
 */
/**
 * @todo Definir superclasse apropriada, e criar construtores
 */
public class DisabledServiceException extends Exception
{
    public DisabledServiceException(String s)
    {
        super(s);
    }
}

