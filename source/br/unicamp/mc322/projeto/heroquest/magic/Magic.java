package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.gameengine.action.Action;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.entity.Caster;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;

/**
 * Representa uma magia
 * 
 * @todo Algumas (por enquanto todas) as magias após verificar se o sucesso falhou lançam exceção de ActionFailed. Alterar checkSucess para fazer isso
 */
public abstract class Magic implements Action

{
    /** Attributes */
    /**
     * Elemento da magia
     */
    private Element element;

    Magic(Element element)
    {
        this.element = element;
    }

    /**
     * Verifica se a magia é lançada com sucesso
     * @param caster - O lançador da magia
     * @return - true se a magia é lançada com sucesso
     * @todo - Mostrar o resultado do dado em algum lugar
     */
    protected boolean checkSucess(Caster caster)
    {
        if(D6Dice.getResult()<caster.getInteligence())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected Caster convertToCaster(Entity origin) throws ActionFailedException
    {
        try
        {
            return (Caster) origin;
        }
        catch(ClassCastException e)
        {
            throw new ActionFailedException("A magia só pode ser lançada por conjuradores",e);
        }
    }
}

