package br.unicamp.mc322.projeto.heroquest.action;

/**
 * @todo mover constantes de Movement para cá
 */
public interface Movable 
{
    public static final float xStepSize = Movement.xStepSize;
    public static final float yStepSize = Movement.yStepSize;

    public void moveBy(float deltaX, float deltaY);

    /**
     * Operation moveN Movimenta a entidade para o norte
     * 
     * @return boolean
     */
    public default void moveN() { // moveUp
        moveBy(0, 1*yStepSize);
    }
    /**
     * Operation moveS
     * Movimenta a entidade para o norte
     * @return boolean
     */
    public default void moveS() { // moveDown
    	moveBy(0, -1*yStepSize);
    }
    /**
     * Operation moveE
     * Movimenta a entidade para o norte
     * @return boolean
     */
    public default void moveE() { // moveRight
    	moveBy(1*xStepSize, 0);
    }
    /**
     * Operation moveW
     * Movimenta a entidade para o norte
     * @return boolean
     */
    public default void moveW() { // moveLeft
    	moveBy(-1*xStepSize, 0);
    }
}
