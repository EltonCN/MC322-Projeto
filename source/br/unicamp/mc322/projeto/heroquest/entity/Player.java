package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.DiceMovement;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Player extends Creature implements Curable
{
	/** Attributes */
    /**
     * Nome do jogador
     */
    private String name;
    
	
    public Player(Pose pose, int nAttackDice, int nDefenseDice, int life) {
		super(pose, nAttackDice, nDefenseDice, life);
		basicMovement = new DiceMovement();
		isFriendly = true;
	}
	
    @Override
    public boolean isPermanent() {
    	return true;
    }
    
    /**
     * Operation cureLife
     * 
     * @hpPlus - number oh Hp healed
     * @return 
     */
    public void cureLife(int hpPlus) {
    	if (hpPlus >= 0)
    		life += hpPlus;
    	else; //TODO ADD EXCEPTION A1 MAYBE?
    }
    
    /**
     * Operation wantStopMoving
     * informs whether the Player has stopped moving
     * @return boolean
     */
    //Eu considerei que ele quer parar de se mover quando aperta qualquer outra tecla se não WASD
    //Então, a gnt pode tirar esse método?
    protected boolean wantStopMoving() {
    	return false; //TODO ADD RELATION TO INPUT LATER
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
	public void run() {
		// TODO Auto-generated method stub
		
	}
    
    
    
    @Override
    public int getDefenseScore(){
    	int defenseFaces = 0;
    	for(int i = 0; i < getNDefenseDice(); i++) {
    		if (CombatDice.getResult() == CombatDiceFace.HEROSHIELD) 
    			defenseFaces += 1;
    	}
    	return defenseFaces;
    }

    public void run()
    {
        if(turn == true)
        {

        }

        turn = false;
    }
}

