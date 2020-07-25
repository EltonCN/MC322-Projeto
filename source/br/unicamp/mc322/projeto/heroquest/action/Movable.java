package br.unicamp.mc322.projeto.heroquest.action;

import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;

/**
 * @todo mover constantes de Movement para cá
 */
public interface Movable 
{
    public static final float xStepSize = Movement.xStepSize;
    public static final float yStepSize = Movement.yStepSize;

    public void moveBy(float deltaX, float deltaY) throws InvalidMovementException;

    /**
     * Operation moveN Movimenta a entidade para o norte
     * 
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveN() throws InvalidMovementException { // moveUp
        moveBy(0, yStepSize);
    }
    /**
     * Operation moveS
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveS() throws InvalidMovementException { // moveDown
    	moveBy(0, -yStepSize);
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveE() throws InvalidMovementException { // moveRight
    	moveBy(xStepSize, 0);
    }
    /**
     * Operation moveW
     * Movimenta a entidade para o norte
     * @return boolean
     * @throws InvalidMovementException 
     */
    public default void moveW() throws InvalidMovementException { // moveLeft
    	moveBy(-xStepSize, 0);
    }
}
