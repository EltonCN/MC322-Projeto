package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.heroquest.action.Movement;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;

/**
 * @todo mover constantes de Movement para cá
 */
public interface Movable 
{
    public static final float xStepSize = Movement.xStepSize;
    public static final float yStepSize = Movement.yStepSize;

    public void moveByAndTurn(float deltaX, float deltaY, float deltaAngle) throws InvalidMovementException;

    /**
     * Operation moveN Movimenta a entidade para o norte
     * 
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveN() throws InvalidMovementException { // moveUp
    	moveByAndTurn(0, yStepSize, getDeltaAngle(90));
    }
    /**
     * Operation moveS
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveS() throws InvalidMovementException { // moveDown
    	moveByAndTurn(0, -yStepSize, getDeltaAngle(270));
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveE() throws InvalidMovementException { // moveRight
    	moveByAndTurn(xStepSize, 0, getDeltaAngle(0));
    }
    /**
     * Operation moveW
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveW() throws InvalidMovementException { // moveLeft
    	moveByAndTurn(-xStepSize, 0, getDeltaAngle(180));
    }
    
    public default float getDeltaAngle(float goal) {
    	return goal - ((Entity) this).getPose().getAngle();
    }
}
