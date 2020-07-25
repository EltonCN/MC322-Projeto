package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.entity.Caster;

public class Fireball extends Magic implements Attack 
{
    private static final Element magicalElement = Element.FIRE;
    private static final Metric metric = Metric.MANHATTAN;
    private static final float damage = 6;
    private static final float adjacentDamage = 3;
    private static final float adjacentDistance = 1;
    private static final float reach = Movement.xStepSize*3;

    Fireball() 
    {
        super(magicalElement);
    }

    @Override
    /**
     * Lança as bolas de fogo
     * 
     * @todo Método para receber o objetivo do ataque
     */
    public void attack(Attacker origin) throws ActionFailedException 
    {
        AttackableRangeArea area = new AttackableRangeArea(origin.getPose(), reach, metric);

        Attackable[] targets = area.getAttackablesInside(origin);

        if(targets.length == 0)
        {
            return;
        }

        attack(origin,targets[0]);

    }

    @Override
    public void attack(Attacker origin, Attackable target) throws ActionFailedException 
    {
        Caster caster = convertToCaster(origin);
       

        if(checkSucess(caster) == false)
        {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado o suficiente");
        }

        target.takeDamage(damage);

        AttackableRangeArea area = new AttackableRangeArea(target.getPose(), adjacentDistance, metric);

        for(Attackable a : area.getAttackablesInside(target.getIsFriendly()))
        {
            a.takeDamage(adjacentDamage);
        }

    }



}

