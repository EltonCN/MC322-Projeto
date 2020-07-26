package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDice;
import br.unicamp.mc322.projeto.heroquest.utility.CombatDiceFace;

public abstract class Enemy extends Creature
{
	public Enemy(Pose pose, int life, int nAttackDice, int nDefenseDice) {
		super(pose, life, nAttackDice, nDefenseDice);
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
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.LOG, "Enemy", "Tentativa de se mover falhou: " + e);

			} catch (NotAvaibleServiceException | DisabledServiceException e1) {
				e1.printStackTrace();
			}
			// @todo tentar implementar o seguinte sem causar loop infinito: se não se moveu => ataque. Se não atacou => se mova 
		}
    	
    	try {
			attack();
		} catch (ActionFailedException e) {
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.OTHER, LogPriority.LOG, "Enemy", "Tentativa de atacar falhou: " + e);

			} catch (NotAvaibleServiceException | DisabledServiceException e1) {
				e1.printStackTrace();
			}
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
