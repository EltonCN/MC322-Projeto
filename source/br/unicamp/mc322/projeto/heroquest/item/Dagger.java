package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.DiceAttack;

public class Dagger extends Weapon 
{
    private static final int hand = 1;
    private static final int uses = 1;  
    private static final int value = 0;
    private static final String name = "Dagger";
    private static final float reach = Movement.xStepSize*3;
    private static final int damageBonus = 1;

    public Dagger() 
    {
        super(name, value, hand, uses);
        attack = new DiceAttack(damageBonus, reach);
    }
}