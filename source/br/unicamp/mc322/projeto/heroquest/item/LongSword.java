package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;

public class LongSword extends Weapon
{
    
    private static final int hand = 2;
    private static final int uses = Integer.MAX_VALUE;  
    private static final int value = 0;
    private static final String name = "Long Sword";
    private static final float reach = Movement.xStepSize;
    private static final int damageBonus = 2;

    private SimpleAttack attack;

    public LongSword() 
    {
        super(name, value, hand, uses);
        this.attack = new SimpleAttack(damageBonus, reach);
    }

    @Override
    public void run(Entity origin) throws ActionFailedException 
    {
        attack.run(origin);

    }

    @Override
    public void run(Entity origin, Attackable target) throws ActionFailedException 
    {
        attack.run(origin, target);
    }
}

