package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.KeyInputService;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.heroquest.entity.Creature;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;

public class DiceMovement implements Movement
{

	@Override
	public void run(Entity origin) {
		// TODO Auto-generated method stub
	}

	@Override
	public void move(Creature mover) {
		int steps = D6Dice.getResult(); // Rolling the dice
		KeyInputService keyboard;
		try {
			keyboard = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);
			boolean didItMove = false;
			boolean doneMoving = false;
			for(int i = 0; i < steps && !doneMoving; i++) {
				switch(keyboard.getUserInput()) {
					case 'a':
						didItMove = mover.moveW();
						break;
					case 'w':
						didItMove = mover.moveN();
						break;
					case 's':
						didItMove = mover.moveS();
						break;
					case 'd':
						didItMove = mover.moveE();
						break;
					default:
						doneMoving = true;
				}
				
				if (!didItMove) i--;
			}
		} catch (NotAvaibleServiceException e) {
			e.printStackTrace();
			System.exit(1); //GAME CANNOT WORK WITHOUT INPUT
		}
	}
}

