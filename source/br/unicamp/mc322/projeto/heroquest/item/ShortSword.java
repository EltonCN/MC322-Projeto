package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;

public class ShortSword extends Weapon {
    private static final int hand = 1;
    private static final int uses = Integer.MAX_VALUE;
    private static final int value = 0;
    private static final String name = "Short Sword";
    private static final float reach = Movement.xStepSize;
    private static final int damageBonus = 2;

    private SimpleAttack attack;

    public ShortSword() {
        super(name, value, hand, uses);
        this.attack = new SimpleAttack(damageBonus, reach);
    }

    @Override
    public void attack(Attacker origin) throws ActionFailedException {
        attack.attack(origin);

    }

    @Override
    public void attack(Attacker origin, Attackable target) throws ActionFailedException 
    {
        attack.attack(origin, target);
    }
}

