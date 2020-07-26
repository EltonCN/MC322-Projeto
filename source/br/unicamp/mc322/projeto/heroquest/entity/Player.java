package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.action.DiceMovement;
import br.unicamp.mc322.projeto.heroquest.action.Lootable;
import br.unicamp.mc322.projeto.heroquest.action.Looter;
import br.unicamp.mc322.projeto.heroquest.item.Item;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Player extends Creature implements Curable, Looter
{
	/** Attributes */
    /**
     * Nome do jogador
     */
    private String name;
    
	
    public Player(Pose pose, int nAttackDice, int nDefenseDice, int life, String name) {
		super(pose, nAttackDice, nDefenseDice, life);
		this.name = name;
		basicMovement = new DiceMovement();
		isFriendly = true;
		turn = false;
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
    
    public void loot(LinkedList<Item> loot) {
    	for(Item i: loot) {
    		addItemToInventory(i);
    	}
    }
    


	@Override
	public void startTurn() {
		turn = true;
		
	}

	@Override
	public boolean isInTurn() {
		return turn;
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
        if(turn == true) {
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

        turn = false;
    }
}

