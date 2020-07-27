package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.KeyInputService;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;

public class DiceMovement implements Movement
{
	@Override
	public void move(Movable mover) throws ActionFailedException
	{
		int steps = D6Dice.getResult(); // Rolling the dice
		KeyInputService keyboard;
		try {
			keyboard = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);
			ImageOutputService output = (ImageOutputService) ServiceManager.getInstance().getService(ServiceType.IMAGEOUTPUT);
			boolean doneMoving = false;
			for(int i = 0; i < steps && !doneMoving; i++) {
				try {
					switch(keyboard.getUserInput()) 
					{
						case 'a':
							mover.moveW();
							break;
						case 'w':
							mover.moveN();
							break;
						case 's':
							mover.moveS();
							break;
						case 'd':
							mover.moveE();
							break;
						case 'q':
							doneMoving = true;
							break;
						default:
							break; // Usuário se enganou: espere ele digitar uma tecla válida
					}
				} 
				catch (InvalidMovementException e) 
				{
					i--;
				}
				catch(DisabledEntityException e)
				{
					throw new ActionFailedException("Entidades desabilitadas não podem se mover", e);
				}



				try 
				{
					output.update();
				} 
				catch (DisabledServiceException e) 
				{
					e.printStackTrace();
				}
				
			}
		} 
		catch (NotAvaibleServiceException e)
		 {
			e.printStackTrace();
			System.exit(1); // Jogo não funciona sem input: Finaliza!
		}
	}
}

