package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.heroquest.action.DiceMovement;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.entity.Caster;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public class Teleport extends Magic implements Movement
{
    private static final int nD6Dice = 2;

    Teleport(Element element) 
    {
        super(element);
    }

    @Override
    public void move(Movable movable) throws ActionFailedException
    {
        Caster caster = convertToCaster(movable);

        if(checkSucess(caster) == false)
        {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado suficiente");
        }

        DiceMovement movement = new DiceMovement();

        for(int i = 0; i<nD6Dice; i++)
        {
            movement.move(movable);
            movement.move(movable);
        }
    }
}

