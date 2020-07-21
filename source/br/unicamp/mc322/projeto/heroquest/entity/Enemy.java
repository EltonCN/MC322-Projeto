package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Enemy extends Creature
{

	public Enemy(Pose pose) {
		super(pose, 3, 2, 2); //We decides as standards to enemys
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public int getDefenseScore(){
    	int defenseFaces = 0;
    	for(int i = 0; i < getNDefenseDice(); i++) {
    		if (CombatDice.getResult() == CombatDiceFace.MONSTERSHIELD) 
    			defenseFaces += 1;
    	}
    	return defenseFaces;
    }
}

