package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.heroquest.action.Movement;

/**
 * @todo mover constantes de Movement para cá
 */
public interface Movable 
{
    public static final float xStepSize = Movement.xStepSize;
    public static final float yStepSize = Movement.yStepSize;

    public void moveBy(float deltaX, float deltaY) throws InvalidMovementException, DisabledEntityException;

    /**
     * Operation moveN Movimenta a entidade para o norte
     * 
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveN() throws InvalidMovementException, DisabledEntityException
     { // moveUp
        moveBy(0, yStepSize);
    }
    /**
     * Operation moveS
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveS() throws InvalidMovementException, DisabledEntityException
     { // moveDown
    	moveBy(0, -yStepSize);
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveE() throws InvalidMovementException, DisabledEntityException
     { // moveRight
    	moveBy(xStepSize, 0);
    }
    /**
     * Operation moveW
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveW() throws InvalidMovementException, DisabledEntityException
     { // moveLeft
    	moveBy(-xStepSize, 0);
    }
}
