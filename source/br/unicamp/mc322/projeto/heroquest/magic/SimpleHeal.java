package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Cure;
import br.unicamp.mc322.projeto.heroquest.entity.Caster;
import br.unicamp.mc322.projeto.heroquest.entity.Curable;

public class SimpleHeal extends Magic implements Cure {
    private static Element magicaElement = Element.WATER;
    private static int nCureD6 = 1;

    SimpleHeal() {
        super(magicaElement);
    }

    @Override
    public void run(Entity origin) throws ActionFailedException 
    {
        Caster caster = convertToCaster(origin);

        Curable curable = null;
        try
        {
            curable = (Curable) origin;
        }
        catch(ClassCastException e)
        {
            throw new ActionFailedException("Apenas curáveis podem lançar essa magia",e);
        }
        

        if(checkSucess(caster) == false)
        {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado o suficiente");
        }

        int curePoints = 0;

        for(int i = 0; i<nCureD6; i++)
        {
            curePoints += D6Dice.getResult();
        }
        
        curable.cureLife(curePoints);
    }
}

