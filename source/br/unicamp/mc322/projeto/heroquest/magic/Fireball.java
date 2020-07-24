package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.heroquest.magic.Magic;
import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
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
    public void run(Entity origin) throws ActionFailedException 
    {
        Caster caster;
        Attacker attacker;

        try
        {
            caster = (Caster) origin;
        }
        catch(ClassCastException e)
        {
            throw new ActionFailedException("A magia só pode ser lançada por conjuradores",e);
        }

        try 
        {
            attacker = (Attacker) origin;   
        } catch (ClassCastException e) 
        {
            throw new ActionFailedException("Por ser uma magia de ataque, apenas atacantes podem lançá-la", e);
        }

        if(checkSucess(caster) == false)
        {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado o suficiente");
        }

        AttackableRangeArea area = new AttackableRangeArea(origin.getPose(), Movement.xStepSize*1, metric);

        Attackable[] targets = area.getAttackablesInside(attacker);

        for(Attackable target : targets)
        {
            target.takeDamage(damage);
        }

    }
}

