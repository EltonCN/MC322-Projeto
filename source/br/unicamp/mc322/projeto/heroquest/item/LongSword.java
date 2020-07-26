package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;

public class LongSword extends Weapon
{
    
    private static final int hand = 2;
    private static final int uses = Integer.MAX_VALUE;  
    private static final int value = 0;
    private static final String name = "Long Sword";
    private static final float reach = 2 * Movement.xStepSize;
    private static final int damageBonus = 2;

    public LongSword() 
    {
        super(name, value, hand, uses);
        attack = new SimpleAttack(damageBonus, reach);
    }
}

