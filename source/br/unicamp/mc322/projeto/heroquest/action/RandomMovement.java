package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
import br.unicamp.mc322.projeto.heroquest.entity.Movable;

public class RandomMovement implements Movement {
	
	

	@Override
	public void move(Movable mover) throws ActionFailedException {
		boolean didItMove  = false;
		while(!didItMove) {
			
			try {
				switch(new RandomGenerator(4).getResult()) {
				case 1:
					mover.moveN();
					break;
				case 2:
					mover.moveS();
					break;
				case 3:
					mover.moveE();
					break;
				case 4:
					mover.moveW();
					break;
				}
				didItMove = true;
			} 
			catch(InvalidMovementException e) 
			{
				throw new ActionFailedException("Movimento inválido", e);
			}
			catch(DisabledEntityException e)

			{
				throw new ActionFailedException("Não é possível mover entidades desabilitadas", e);
			}
			
		}

	}

}
