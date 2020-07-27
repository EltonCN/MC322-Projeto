package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.heroquest.entity.Attackable;
import br.unicamp.mc322.projeto.heroquest.entity.Attacker;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public class DiceAttack extends SimpleAttack implements Attack{
   
    public DiceAttack (int damageBonus, float reach)
    {
        super(damageBonus, reach);
    }

    protected void doAttack(Attacker attacker, Attackable target)
    {
        int defenseScore = target.getDefenseScore();

        int attackScore = attacker.getAttackScore(); 

        if(attackScore < defenseScore) {
            return;
        }

        int bonus = 0;

        for(int i = 0; i < damageBonus; i++) {
            if(CombatDice.getResult() == CombatDiceFace.SKULL) {
                bonus += 1;
            }
        }

        target.takeDamage((attackScore - defenseScore) + bonus);
		
    }
    
}

