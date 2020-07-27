package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public class RandomMovement implements Movement {
	
	

	@Override
	public void move(Movable mover) throws ActionFailedException {
		boolean didItMove  = false;
		do {
			
			try {
				switch(new RandomGenerator(4).getResult()) {
				case 1:
					mover.moveN();
					didItMove = true;
					break;
				case 2:
					mover.moveS();
					didItMove = true;
					break;
				case 3:
					mover.moveE();
					didItMove = true;
					break;
				case 4:
					mover.moveW();
					didItMove = true;
					break;
				}
			}
			
			catch(InvalidMovementException e) 
			{
				try {
					didItMove = false;
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.OTHER, LogPriority.LOG, "RandomMovement", "Tentativa de se mover para posição ocupada");

				} catch (NotAvaibleServiceException | DisabledServiceException e1) {
					e1.printStackTrace();
				}
			}
			
			catch(DisabledEntityException e)

			{
				throw new ActionFailedException("Não é possível mover entidades desabilitadas", e);
			}
			
		} while(!didItMove);

	}

}
