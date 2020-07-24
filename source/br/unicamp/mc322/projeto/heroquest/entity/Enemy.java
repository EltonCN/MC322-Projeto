package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityPrototype;
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Enemy extends Creature
{

	public Enemy(Pose pose) {
		super(pose, 3, 2, 2); //We decided as standards to enemys
		basicMovement = new RandomMovement();
		isFriendly = false;
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

	@Override
	public void run() {
    	try {
			basicMovement.run(this);
		} catch (ActionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			attack();
		} catch (ActionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void startTurn() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isInTurn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntityPrototype createPrototype() {
		Object[] args= new Object[0];
		return new EntityPrototype(getClass(), getPose(), args);
	}
}

