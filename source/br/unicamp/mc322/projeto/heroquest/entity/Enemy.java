package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Enemy extends Creature
{
	private boolean turn;

	public Enemy(Pose pose) {
		super(pose, 3, 2, 2); //We decided as standards to enemys
		basicMovement = new RandomMovement();
		isFriendly = false;

		turn = false;
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

		turn = false;
    }

	@Override
	public void startTurn() 
	{
		turn = true;
	}

	@Override
	public boolean isInTurn() 
	{
		return turn;
	}


}
