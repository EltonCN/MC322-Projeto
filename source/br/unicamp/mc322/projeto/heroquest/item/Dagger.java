package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;

public class Dagger extends Weapon 
{
    private static final int hand = 1;
    private static final int uses = 1;  
    private static final int value = 0;
    private static final String name = "Dagger";
    private static final float reach = Movement.xStepSize*3;
    private static final int damageBonus = 1;

    private SimpleAttack attack;

    public Dagger() 
    {
        super(name, value, hand, uses);
        this.attack = new SimpleAttack(damageBonus, reach);
    }

    @Override
    public void run(Entity origin) throws ActionFailedException 
    {
        attack.run(origin);

    }
}

