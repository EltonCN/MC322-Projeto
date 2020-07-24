package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.heroquest.action.Attack;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.entity.Caster;

/**
 * Magia Mísseis Mágicos
 * 
 * @todo Possui métodos identicos à Fireball. Pode possuir superclasse ou composição em comum
 */
public class MagicMissile extends Magic implements Attack 
{
    private static final Metric metric = Metric.MANHATTAN;
    private static final float damage = 2;
    private static final float reach = Movement.xStepSize*3;
    private static final int nMissile = 3;

    private static final Element magicalElement = Element.NEUTRAL;

    MagicMissile() 
    {
        super(magicalElement);
    }

    @Override
    public void run(Entity origin) throws ActionFailedException
    {
        Attacker attacker = convertToAttacker(origin);

        AttackableRangeArea area = new AttackableRangeArea(origin.getPose(), reach, metric);

        Attackable[] targets = area.getAttackablesInside(attacker);

        if(targets.length == 0)
        {
            return;
        }
        run(origin,targets[0]);
    }

    @Override
    public void run(Entity origin, Attackable target) throws ActionFailedException 
    {
        Caster caster = convertToCaster(origin);

        if(checkSucess(caster) == false)
        {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado o suficiente");
        }

        target.takeDamage(damage*nMissile);

    }


    private Attacker convertToAttacker(Entity origin) throws ActionFailedException
    {
        try 
        {
            return  (Attacker) origin;   
        } catch (ClassCastException e) 
        {
            throw new ActionFailedException("Por ser uma magia de ataque, apenas atacantes podem lançá-la", e);
        }
    }
}

