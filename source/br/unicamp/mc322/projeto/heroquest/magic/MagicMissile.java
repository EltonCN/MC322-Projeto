package br.unicamp.mc322.projeto.heroquest.magic;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
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
    private static final float reach = Movement.xStepSize * 3;
    private static final int nMissile = 3;

    private static final Element magicalElement = Element.NEUTRAL;

    public MagicMissile() {
        super(magicalElement);
    }

    @Override
    public void attack(Attacker origin) throws ActionFailedException {
        AttackableRangeArea area = new AttackableRangeArea(origin.getPose(), reach, metric);

        Attackable[] targets = area.getAttackablesInside(origin);

        if(targets.length == 0) {
            return;
        }
        attack(origin,targets[0]);
    }

    @Override
    public void attack(Attacker origin, Attackable target) throws ActionFailedException {
        Caster caster = convertToCaster(origin);

        if(checkSucess(caster) == false) {
            throw new ActionFailedException("O conjurador não conseguiu um valor no dado o suficiente");
        }

        target.takeDamage(damage*nMissile);

    }


}

