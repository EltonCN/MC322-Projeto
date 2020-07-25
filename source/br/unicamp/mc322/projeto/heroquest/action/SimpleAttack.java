package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;
import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public class SimpleAttack
 implements Attack
{
    /** Attributes */
    /**
     * Dano do ataque
     */
    private int damageBonus;
    /**
     * Alcance do ataque
     */
    private float reach;
    /**
     * Operation SimpleAttack
     * Construtor de SimpleAttack
     *
     * @param damageBonus - Bônus de dano do ataque
     * @param reach - Alcance do ataque
     * @return 
     */
    public SimpleAttack (int damageBonus, float reach)
    {
        this.damageBonus = damageBonus;
        this.reach = reach;
    }

    @Override
    /**
     * Executa o ataque
     * @todo verificar se todos os castings são necessários
     * @todo mostrar em algum lugar os resultados dos dados bônus
     */
    public void attack(Attacker origin) throws ActionFailedException
    {
   
        AttackableRangeArea area = new AttackableRangeArea(origin.getPose(), reach, metric);

        Attackable[] targets = area.getAttackablesInside(origin);

        if(targets.length == 0)
        {
            throw new ActionFailedException("Não existem alvos para atacar");
        }

        Attackable finalTarget = null;
        float minDistance = Float.MAX_VALUE;

        for(Entity a : (Entity[]) targets )
        {
            if(a.getPose().distance(origin.getPose(), metric) < minDistance)
            {
                minDistance = a.getPose().distance(origin.getPose(), metric);
                finalTarget = (Attackable) a;
            }

        }

        doAttack(origin, finalTarget);

    }

    @Override
    public void attack(Attacker origin, Attackable target) throws ActionFailedException 
    {
        if(origin.getPose().distance(target.getPose(), metric) < this.reach)
        {
            throw new ActionFailedException("O alvo está fora de alcance");
        }

        doAttack(origin, target);
    }

    private void doAttack(Attacker attacker, Attackable target)
    {
        int defenseScore = target.getDefenseScore();

        int attackScore = attacker.getAttackScore(); 

        if(attackScore<defenseScore)
        {
            return;
        }

        int bonus = 0;

        for(int i = 0; i<damageBonus; i++)
        {
            if(CombatDice.getResult() == CombatDiceFace.SKULL)
            {
                bonus += 1;
            }
        }

        target.takeDamage((attackScore-defenseScore)+bonus);
		
    }
    
}

