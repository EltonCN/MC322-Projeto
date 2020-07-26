package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.KeyInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.action.DiceMovement;
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
    protected String name;
    
    @SuppressWarnings("unused")
	private float money;
    
	
    public Player(Pose pose, int nAttackDice, int nDefenseDice, int life, String name) {
		super(pose, nAttackDice, nDefenseDice, life);
		this.name = name;
		basicMovement = new DiceMovement();
		isFriendly = true;
		turn = false;
		money = 0;
	}
	
    @Override
    public boolean isPermanent() {
    	return true;
    }
    
    @Override
    protected void addItemToInventory(Item item) {
    	if (!item.getName().equals("Golden Coin"))
    		super.addItemToInventory(item);
    	else
    		enrich(item);
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
    	else {
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Player", "Tentativa de usar cureLife para tirar vida");
			} catch (NotAvaibleServiceException | DisabledServiceException e) {
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * Implementação padrão do que acontece quando Player loota algo
     * Implementações diferenciadas podem ser chamadas usando apenas a interface Lootable
     */
    public void loot(LinkedList<Item> loot) {
    	for(Item i: loot) {
    		addItemToInventory(i);
    	}
    	for(int i = 0; i < loot.size(); i++)  {
    		loot.remove();
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
        if (turn == false)
        	return;
       	try {
   			basicMovement.run(this);
  		} catch (ActionFailedException e) {
   			e.printStackTrace();
   		}
       	
       	
       	try {
			ImageOutputService output = (ImageOutputService) ServiceManager.getInstance().getService(ServiceType.IMAGEOUTPUT);
			output.update();
		} catch (NotAvaibleServiceException | DisabledServiceException e2) {
			e2.printStackTrace();
		}
       	
       	
       	
       	KeyInputService k;
       	try {
			k = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);
			boolean choiseMade = false;
			
			do {
				char order = k.getUserInput();
	        	
				if (order == '1') 
				{
	        		try {
	        			attack();
	        		} catch (ActionFailedException e) {
	        		}
		       		
		       		choiseMade = true;
		       	} 
				
				else if (order == '2') {
		       		interact();
		       		choiseMade = true;
		       	}
				
				else if (order == '3') {
					try {
			       		((Caster) this).runMagics();
			       		choiseMade = true;
					} catch (ActionFailedException e1) {
						try {
							LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
							l.sendLog(LogType.OTHER, LogPriority.LOG, "Player", "Tentativa inválida de usar magia: " + e1);
						} catch (NotAvaibleServiceException | DisabledServiceException e) {
							e.printStackTrace();
						}
					}
				}

			} while(!choiseMade);
			
			turn = false;
			
		} catch (NotAvaibleServiceException e1) {
			e1.printStackTrace();
		}
        	
        	

        turn = false;
    }
    
    private void interact() {
    	Interactable[] interactables = Interactable.getInteractablesNear(this);
    	for(Interactable obj: interactables) {
    		obj.interact(this);
    	}
    }
    
    public void enrich(Item it) {
    	float value = it.getValue();
    	if (value < 0) {
    		
    		try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.ERROR, "Player", "Operação inválida para número negativo");
				money -= value;
				return;
			} catch (NotAvaibleServiceException | DisabledServiceException e) {
				e.printStackTrace();
			}

    		
    	}
    	money += value;
    }
}

